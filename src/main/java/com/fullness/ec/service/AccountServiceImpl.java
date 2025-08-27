package com.fullness.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullness.ec.entity.AccountCategories;
import com.fullness.ec.entity.Employee;
import com.fullness.ec.repository.AccountCategoryRepository;
import com.fullness.ec.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountCategoryRepository accountCategoryRepository;

    /***
     * 社員情報を取得する
     * 
     * @return 社員情報リスト
     */
    // @Transactional
    @Override
    public List<Employee> getEmployee() {
        return accountRepository.selectAll();//
    }

    @Override
    public List<AccountCategories> sameAccountName() {
        return accountRepository.selectByAccountName();
    }

    @Override
    public void addAccount(AccountCategories accountCategories) {
        accountCategoryRepository.insert(accountCategories);
    }

}
