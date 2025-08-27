package com.fullness.ec.helper;

import org.springframework.stereotype.Component;

import com.fullness.ec.entity.AccountCategories;

import com.fullness.ec.form.AccountForm;
@Component
public class AccountHelper {
    public static AccountCategories convert(AccountForm accountForm) {// convert()で変換する。
        AccountCategories accountCategories = new AccountCategories();// AccountCategoriesエンティティのインスタンスを生成
        accountCategories.setAccountName(accountForm.getAccountName());// accountFormのaccountNameをaccountCategoriesクラスのsetAccountNameに格納
        accountCategories.setPassword(accountForm.getPassword());// accountFormのpasswordをaccountCategoriesクラスのsetPasswordに格納
        return accountCategories;// AccountCategoriesクラスに返す
    }
}
