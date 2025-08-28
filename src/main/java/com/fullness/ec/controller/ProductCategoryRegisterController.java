package com.fullness.ec.controller;

import com.fullness.ec.form.ProductCategoryForm;
import com.fullness.ec.entity.ProductCategory;
import com.fullness.ec.service.ProductCategoryResisterService;
import com.fullness.ec.helper.ProductCategoryHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("admin/productcategory/register")
@SessionAttributes({ "productCategoryForm" })
public class ProductCategoryRegisterController {

    @Autowired
    private ProductCategoryResisterService categoryService;
    @Autowired
    private ProductCategoryHelper productCategoryHelper;

    @ModelAttribute
    public ProductCategoryForm setupForm() {
        return new ProductCategoryForm();
    }

    /** 入力画面 */
    @GetMapping("input")
    public String input(Model model) {
        return "admin/productcategory/register/input";
    }

    /** 入力画面の[確認]クリック → 確認画面 */
    @PostMapping("confirm")
    public String confirm(
            @Validated @ModelAttribute("productCategoryForm") ProductCategoryForm form,
            BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            return "admin/productcategory/register/input";
        }

        // --- 重複チェック ---
        if (categoryService.isCategoryExists(form.getName())) {
            result.rejectValue("name", "productCategoryForm.name.duplicate");
            return "admin/productcategory/register/input";
        }

        return "admin/productcategory/register/confirm";
    }

    /** 確認画面の[登録]クリック → 完了画面 */
    @PostMapping("execute")
    public String register(@ModelAttribute("productCategoryForm") ProductCategoryForm form,
            BindingResult result,
            RedirectAttributes ra,
            Model model) {

        // もう一度重複チェック
        if (categoryService.isCategoryExists(form.getName())) {
            result.rejectValue("name", "productCategoryForm.name.duplicate");
            return "admin/productcategory/register/input";
        }
        ProductCategory category = productCategoryHelper.convert(form);
        categoryService.addProductCategory(category);
        ra.addFlashAttribute("completed", true);
        return "redirect:/admin/productcategory/register/complete";
    }

    /** 完了画面 */
    @GetMapping("complete")
    public String complete(ProductCategoryForm productCategoryForm, SessionStatus status, Model model) {
        if (!model.containsAttribute("completed")) {
            return "redirect:/admin/productcategory/register/input";
        }
        model.addAttribute("addCategoryName", productCategoryForm.getName());
        status.setComplete();
        return "admin/productcategory/register/complete";
    }

    /** 確認画面の[戻る]クリック */
    @PostMapping("input")
    public String back() {
        return "redirect:/admin/productcategory/register/input";
    }
}
