package com.esliceu.Maze.dao;

import com.esliceu.Maze.model.Door;
import com.esliceu.Maze.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DoorDAOImpl implements DoorDAO{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Door getDoorByID(int doorId) {
        return jdbcTemplate.queryForObject(
                "select * from doors where id = ?",
                new BeanPropertyRowMapper<>(Door.class),
                doorId
        );
    }
}

