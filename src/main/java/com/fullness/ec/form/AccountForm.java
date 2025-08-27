package com.fullness.ec.form;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountForm {
    @NotNull
    private String accountName;
    @NotNull
    private String password;
    @NotNull
    private Integer accountId;
    @NotNull
    private String empName;
    private String empKana;
    private String empDepartmentId;
}
