package com.esliceu.Maze.dao;

import com.esliceu.Maze.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    
    static List<User> users = new ArrayList<>();

    static {
        users.add(new User("Bill","bill", "1234"));
        users.add(new User("Tom", "tom", "aaaa"));
        users.add(new User("Jack","jack", "bbbb"));
        users.add(new User("Magda","magda", "cccc"));
        users.add(new User("Jhon","jhon", "dddd"));
    }


    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return jdbcTemplate.queryForObject("select * from users where username = ? and password = ?",
                new BeanPropertyRowMapper<>(User.class),
                username, password);
    }
    @Override
    public User findByUsername(String username) {
        return jdbcTemplate.queryForObject("select * from users where username = ?",
                new BeanPropertyRowMapper<>(User.class),
                username);
    }
    @Override
    public void saveUser(String name, String username, String password) {
        jdbcTemplate.update("insert into users (name, username, password) VALUES (?, ?, ?)",
                name, username, password);
    }
}
