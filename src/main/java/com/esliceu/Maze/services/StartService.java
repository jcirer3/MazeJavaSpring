package com.esliceu.Maze.services;

import com.esliceu.Maze.dao.MapDAO;
import com.esliceu.Maze.dao.MapDAOImpl;
import com.esliceu.Maze.model.Map;
import com.esliceu.Maze.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.expression.Maps;

import java.util.List;

@Service
public class StartService {
    @Autowired
    MapDAO mapDAO = new MapDAOImpl();

    public Map getMapById (int id ){
        return mapDAO.getMapByID(id);
    }

    public Room getRoomById (int id){
        return mapDAO.getRoomByID(id);
    }

    public List<Map> getAllMaps (){
        return mapDAO.getAllMaps();
    }


}
