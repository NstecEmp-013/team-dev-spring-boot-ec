package com.fullness.ec.repository;

import org.apache.ibatis.annotations.Mapper;

import com.fullness.ec.entity.AccountCategories;
@Mapper
public interface AccountCategoryRepository {

    void insert(AccountCategories accountCategories);// アカウント情報を登録する

}
