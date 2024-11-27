package com.esliceu.Maze.controllers;


import com.esliceu.Maze.model.Room;
import com.esliceu.Maze.model.User;
import com.esliceu.Maze.services.NavService;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NavController {

    @Autowired
    NavService navService;

    @GetMapping("/nav")
    public String showNavPage(HttpSession session, Model model, @RequestParam String dir) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        if (dir != null && !dir.isEmpty()) {
            System.out.println("Direccio en GET: " + dir);
        }
        System.out.println("estas en nav");
        return "nav";
    }

    @PostMapping("/nav")
    public String navigate(HttpSession session, Model model, @RequestParam String direction) {
        System.out.println("nav de post");
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        return "nav"; // Reload the nav page view with updated data.
    }
}
