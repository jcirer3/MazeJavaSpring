package com.esliceu.Maze.controllers;

import com.esliceu.Maze.services.RegisterService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @GetMapping("/register")
    public String showRegisterPage(){
        return "register";
    }

    @PostMapping("/perform-register")
    public String performRegister (@RequestParam String name, @RequestParam String username, @RequestParam String password){
        registerService.saveUser(name, username, password);
        return "redirect/login";
    }
}
