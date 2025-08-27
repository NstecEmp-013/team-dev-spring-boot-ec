package com.fullness.ec.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fullness.ec.entity.AccountCategories;
import com.fullness.ec.entity.Employee;

@Mapper
public interface AccountRepository {

    List<Employee> selectAll();// 社員情報を取り出す

    List<AccountCategories> selectByAccountName(); // アカウント名を取り出す

    
}
