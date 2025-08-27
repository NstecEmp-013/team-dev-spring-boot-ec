package com.fullness.ec.form;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;


import lombok.Data;

import org.springframework.validation.Errors;
@Data
@Component
public class LoginFormValidator implements Validator {
@Override
public boolean supports(Class<?> clazz) {
    return LoginForm.class.isAssignableFrom(clazz);
}
@Override
public void validate(Object target, Errors errors) {
    LoginForm loginForm = (LoginForm) target;
    if (loginForm.getUsername() == null || loginForm.getPassword() == null) {
        errors.reject("jakarta.validation.constraints.NotNull.message");
    }
    if (loginForm.getUsername().length() < 5 || loginForm.getUsername().length() > 20) {
        errors.reject("org.hibernate.validator.constraints.Length.message");
    }
    if (loginForm.getPassword().length() < 5 || loginForm.getPassword().length() > 20) {
        errors.reject("org.hibernate.validator.constraints.Length.message");
    }
}
}