package com.fullness.ec.repository;

import org.apache.ibatis.annotations.Mapper;

import com.fullness.ec.entity.EmployeeAccount;
/**
 * 従業員アカウントテーブルをアクセスするリポジトリインターフェース
 */
@Mapper
public interface EmployeeAccountRepository {
    
    /**
     * 指定されたユーザー名でアカウントを取得する
     * @param name ユーザー名
     * @return
     */
    EmployeeAccount selectByName(String name);
}
