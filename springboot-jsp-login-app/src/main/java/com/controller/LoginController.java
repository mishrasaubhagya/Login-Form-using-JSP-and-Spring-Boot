package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.LoginService;



@Controller
public class LoginController {
    
    @Autowired
    LoginService service;

    @GetMapping("/login") 
    public String viewLoginPage(ModelMap map) {
        return "login";
    }

    @PostMapping("/login") 
    public String showWelcomePage(ModelMap map,@RequestParam String name,@RequestParam String password) {

        boolean isValidUser = service.validateUser(name, password);

        if(!isValidUser)
        {
            map.put("errorMessage","Access Denied , Invalid Creddentials");
        }

        map.put("name", name);
        map.put("password", password);

        return "welcome";
    }

    @GetMapping("/logout")
    public String showLogoutPage(ModelMap map) {

        return "login";
    
    }
}
