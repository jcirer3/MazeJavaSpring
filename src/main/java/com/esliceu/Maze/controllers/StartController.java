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

import java.util.HashMap;
import java.util.List;

@Controller
public class StartController {
    @Autowired
    StartService startService;

    @GetMapping("/start")
    public String showHomePage(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        List<Map> maps = startService.getAllMaps();
        model.addAttribute("maps", maps);
        System.out.println("hola en start");
        return "start";
    }

    @PostMapping("/start")
    public String getMap(@RequestParam String mapId, Model model) {
        System.out.println("Map ID recibido: " + mapId);

        Map map = startService.getMapById(Integer.parseInt(mapId));
        Room room = startService.getRoomById(map.getFirstRoom());
        String jsonData = new Gson().toJson(room);


        HashMap<String, Object> mapa = new HashMap<>();
        mapa.put("map", map.getName());
        mapa.put("first", map.getFirstRoom());
        mapa.put("last", map.getLastRoom());
        mapa.put("north", room.getNorth());
        mapa.put("south", room.getSouth());
        mapa.put("east", room.getEast());
        mapa.put("west", room.getWest());
        mapa.put("coin", room.getCoin());
        mapa.put("key", room.getKeyId());



        System.out.println("JsonData:" + jsonData);

        System.out.println("Primera Room: " + map.getFirstRoom());

        model.addAttribute("roomData", jsonData); // Add JSON to model
        return "mapa";
    }
}
