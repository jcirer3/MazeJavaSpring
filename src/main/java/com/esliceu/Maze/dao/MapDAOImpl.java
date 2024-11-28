package com.esliceu.Maze.dao;

import com.esliceu.Maze.model.Map;
import com.esliceu.Maze.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MapDAOImpl implements MapDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Map getMapByID(int id) {
        return jdbcTemplate.queryForObject(
                "select * from maps where id = ?",
                new BeanPropertyRowMapper<>(Map.class),
                id
        );
    }

    @Override
    public Room getRoomByID(int id){
        return jdbcTemplate.queryForObject(
                "select * from rooms where id = ?",
                new BeanPropertyRowMapper<>(Room.class),
                id
        );
    }

    @Override
    public List<Map> getAllMaps(){
        return jdbcTemplate.query(
                "select * from maps",
                new BeanPropertyRowMapper<>(Map.class)
        );
    }
}
