package com.esliceu.Maze.controllers;

import com.esliceu.Maze.exceptions.PasswordToShortException;
import com.esliceu.Maze.exceptions.UserAlreadyExistException;
import com.esliceu.Maze.services.RegisterService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String performRegister (@RequestParam String name, @RequestParam String username, @RequestParam String password, Model model){
        try{
            registerService.saveUser(name, username, password);
            return "redirect:/login";
        } catch (PasswordToShortException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        } catch (UserAlreadyExistException e){
            model.addAttribute("error", e.getMessage());
            return "register";
        } catch (Exception e){
            model.addAttribute("error", "Error inesperado. Vuelve a intentarlo.");
            return "register";
        }
    }
}
