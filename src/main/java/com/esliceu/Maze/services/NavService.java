package com.esliceu.Maze.services;

import com.esliceu.Maze.dao.DoorDAO;
import com.esliceu.Maze.dao.MapDAO;
import com.esliceu.Maze.model.Door;
import com.esliceu.Maze.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NavService {
    @Autowired
    MapDAO mapDAO;

    @Autowired
    DoorDAO doorDAO;

    public Room navigate(int currentRoomId, String direction) {
        System.out.println("func navigate");
        return null;
    }
}
