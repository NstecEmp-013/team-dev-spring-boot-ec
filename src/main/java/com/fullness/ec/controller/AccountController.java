package com.fullness.ec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fullness.ec.entity.Employee;
import com.fullness.ec.form.AccountForm;
import com.fullness.ec.helper.AccountHelper;
import com.fullness.ec.service.AccountService;

@SessionAttributes({ "accountForm", "categoryList" })
@Controller
@RequestMapping("admin/account")

public class AccountController {
    @Autowired
    private AccountService accountService;    
//@Autowired
  //  private AccountForm accountForm;
   
    
    @ModelAttribute
    public AccountForm setupForm(){
        return new AccountForm();
    }

    /**
     * すべての社員をModelに格納する
     * 
     * @return
     */
    @ModelAttribute("employees")
    public List<Employee> Employees() {
        return accountService.getEmployee();
    }

    @ModelAttribute("categoryList")
    public List<Employee> categoryList() {
        return accountService.getEmployee();
    }

    @GetMapping("input")
    public String input(Model model) {
        // accountService.getEmployee()で社員名を取得し、"categoryList"という名前でmodelにセット
        model.addAttribute("categoryList", accountService.getEmployee());
        // 社員名をviewへ表示
        return "admin/account/input";
    }

    @PostMapping("confirm")
    public String confirm(@Validated AccountForm accountForm ,BindingResult bindingResult, Model model) {
        // accountService.sameAccountName()でアカウント名を取得し、"accountCategories"という名前でmodelにセット
        model.addAttribute("accountCategories", accountService.sameAccountName());
        // 入力されたアカウント名、パスワードのaccountFormをモデルにセット
        model.addAttribute("AccountForm", accountForm);
        // 入力画面confirmを表示
        return "admin/account/confirm";
    }

    @PostMapping("execute")
    public String execute(@ModelAttribute("AccountForm") AccountForm accountForm,
            RedirectAttributes redirectAttributes) {
        // accountFormをAccountエンティティに変換してDBに登録
        accountService.addAccount(AccountHelper.convert(accountForm));
        // リダイレクト先にaccountFormFlashという名前でAccountFormを渡す、リダイレクト先は、complete()になる。
        redirectAttributes.addFlashAttribute("accountFormFlash", accountForm);
        // 登録したデータをaddFlashAttributeで追加し、completeに送る。
        return "redirect:/admin/account/complete";
    }

    @GetMapping("complete")
    public String complete(AccountForm accountForm, SessionStatus status, Model model) {
       /*  if (!model.containsAttribute("completed")) {
            return "redirect:/admin/account/input";
        } */
        model.addAttribute("addEmpName", accountForm.getEmpName());
        model.addAttribute("addaccountId", accountForm.getAccountName());
        // セッションをクリアする
        status.setComplete();
        // 完了画面に遷移する
        return "admin/account/complete";
    }

    /**
     * 確認画面の[戻る]ボタンクリック
     * 
     * @return
     */
    @PostMapping("back")
    public String back() {
        return "admin/account/input";
    }

}
