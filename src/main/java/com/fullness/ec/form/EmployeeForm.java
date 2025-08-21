package com.fullness.ec.form;
import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeForm implements Serializable{
    private Integer id;
    @NotBlank
    private String  name;
    @NotBlank
    @Pattern(
    regexp = "^[\\p{IsKatakana}ー・ 　]+$", // 全角スペース(　)と半角スペース( )を許可
    message = "{employee.kana.invalid}")
    private String  kana;
    @NotNull
    private Integer departmentId;
}
