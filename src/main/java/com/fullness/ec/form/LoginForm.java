package com.fullness.ec.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


import lombok.Data;
@Data
public class LoginForm {
    @NotNull
    @Min(5)
    @Max(20)
    private String username;
    @NotNull
    @Min(5)
    @Max(20)
    private String password;
}
