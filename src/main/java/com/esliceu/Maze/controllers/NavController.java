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
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class NavController {

    @Autowired
    NavService navService;

    @GetMapping("/nav")
    public String showNavPage(HttpSession session, Model model, @SessionAttribute("user") User user, @RequestParam String dir) {
        int currentRoomId = user.getIdActualRoom();
        System.out.println("hab actual " + currentRoomId);

        Room nextRoom = navService.navigate(currentRoomId, dir);
        System.out.println("següent hab " + nextRoom.toString());

        user.setIdActualRoom(nextRoom.getId());
        session.setAttribute("user", user);

        String jsonData = new Gson().toJson(nextRoom);
        System.out.println(jsonData);
        model.addAttribute("roomData", jsonData);

        return "mapa";
    }

    @PostMapping("/nav")
    public String navigate(HttpSession session, Model model, @RequestParam String direction) {
        System.out.println("nav de post");
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        return "nav";
    }
}
