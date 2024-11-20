package com.esliceu.Maze.dao;

import com.esliceu.Maze.model.Map;
import com.esliceu.Maze.model.Room;

import java.util.List;

public interface MapDAO {
    Map getMapByID (int id);
    public Room getRoomByID(int id);
    List<Map> getAllMaps();
}
