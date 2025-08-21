package com.fullness.ec.form;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterEmployeeAcountForm implements Serializable{
    @NotBlank
    @Length(min = 5,max = 20)
    private String  name;       // ユーザー名
    @NotBlank
    @Length(min = 5 ,max = 20)
    private String  password;   // パスワード
    private Integer employeeId; // 従業員Id
    private String  employeeName;// 従業員名
}
