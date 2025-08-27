package com.fullness.ec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("admin")
public class MenuController {
    @GetMapping
    public String menu() {
        return "admin/index";
    }    
    
}
