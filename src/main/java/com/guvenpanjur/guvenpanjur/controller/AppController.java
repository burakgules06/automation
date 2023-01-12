package com.guvenpanjur.guvenpanjur.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }
}
