package com.fullness.ec.service;

import java.util.List;

import com.fullness.ec.entity.AccountCategories;
import com.fullness.ec.entity.Employee;

public interface AccountService {
    public List<Employee> getEmployee();//List型で社員名を取得するメソッド
    public List<AccountCategories> sameAccountName();//List型でアカウント名を取得するメソッド
    void addAccount(AccountCategories accountCategories); // アカウントを追加するメソッド
}