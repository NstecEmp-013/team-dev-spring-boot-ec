package com.fullness.ec.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 従業員アカウントを表すエンティティクラス
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeAccount {
    private Integer id;         // 従業員アカウントId
    private String  name;       // 従業員アカウント名
    private String  password;   // パスワード
    private Integer employeeId; // 従業員Id
}
