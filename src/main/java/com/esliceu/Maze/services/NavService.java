package com.esliceu.Maze.services;

import com.esliceu.Maze.dao.DoorDAO;
import com.esliceu.Maze.dao.MapDAO;
import com.esliceu.Maze.model.Door;
import com.esliceu.Maze.model.Room;
import com.esliceu.Maze.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NavService {
    @Autowired
    MapDAO mapDAO;

    @Autowired
    DoorDAO doorDAO;

    public Room navigate(int currentRoomId, String direction) {
        System.out.println("Navigant desde la hab ID: " + currentRoomId + " in direccio: " + direction);

        Room currentRoom = mapDAO.getRoomByID(currentRoomId);
        int doorId = -1;

        switch (direction.toLowerCase()) {
            case "north":
                doorId = currentRoom.getNorth();
                break;
            case "south":
                doorId = currentRoom.getSouth();
                break;
            case "east":
                doorId = currentRoom.getEast();
                break;
            case "west":
                doorId = currentRoom.getWest();
                break;
            default:
                throw new IllegalArgumentException("Invalid direction: " + direction);
        }

        if (doorId == -1) {
            return currentRoom;
        }
        System.out.println("door id : " + doorId);
        Door door = doorDAO.getDoorByID(doorId);
        System.out.println("La porta es " + door);
        if (door == null) {
            return currentRoom;
        }

        if (door.isIs_locked()) {
            return currentRoom;
        }

        // Si estàs a 1 vas a 2 i vicecersa
        if (door.getRoom1() == currentRoomId) {
            System.out.println("Navigating to room " + door.getRoom2());
            return mapDAO.getRoomByID(door.getRoom2());
        } else {
            System.out.println("Navigating to room " + door.getRoom1());
            return mapDAO.getRoomByID(door.getRoom1());
        }
    }
}
