package com.esliceu.Maze.controllers;

import com.esliceu.Maze.model.Map;
import com.esliceu.Maze.model.Room;
import com.esliceu.Maze.services.StartService;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StartController {
    @Autowired
    StartService startService;

    @GetMapping("/start")
    public String showHomePage(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        System.out.println("hola en start");
        return "start";
    }

    @PostMapping("/start")
    public String getMap(@RequestParam String mapId, Model model) {
        System.out.println(mapId);
        Map map = startService.getMapById(Integer.parseInt(mapId));
        Room room = startService.getRoomById(map.getFirstRoom());
        String jsonData = new Gson().toJson(room);
        System.out.println(jsonData);
        System.out.println(map.toString());
        System.out.println(room.toString());
        System.out.println("Room: " + map.getFirstRoom());

        model.addAttribute("mapData", jsonData);
        model.addAttribute("firstRoom", map.getFirstRoom());
        return "start";
    }
}
