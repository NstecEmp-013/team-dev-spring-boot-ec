package com.fullness.ec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.BindingResult;

import com.fullness.ec.form.LoginFormValidator;

@Controller
public class LoginController {
    @GetMapping("admin/login")
    public String login() {
        return "admin/login";
    }
}
