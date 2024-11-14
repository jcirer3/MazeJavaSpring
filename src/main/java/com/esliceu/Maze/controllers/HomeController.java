package com.esliceu.Maze.controllers;

import com.esliceu.Maze.services.HomeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    HomeService homeService;

    @GetMapping("/home")
    public String showHomePage(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        return "home"; // View for the home page
    }
}
