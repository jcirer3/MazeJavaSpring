package com.esliceu.Maze.dao;

import com.esliceu.Maze.model.User;
import com.esliceu.Maze.utils.Encrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    Encrypter encrypter;

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
        try {
            String encryptedPassword = encrypter.encryptedString(password);
            return jdbcTemplate.queryForObject("select * from users where username = ? and password = ?",
                    new BeanPropertyRowMapper<>(User.class),
                    username, encryptedPassword);
        } catch (Exception e) {
            throw new RuntimeException("No és vàlid", e);
        }
    }
    @Override
    public User findByUsername(String username) {
        try {
            return jdbcTemplate.queryForObject(
                    "select * from users where username = ?",
                    new BeanPropertyRowMapper<>(User.class),
                    username
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    @Override
    public void saveUser(String name, String username, String password) {
        try {
            String encryptedPassword = encrypter.encryptedString(password);
            jdbcTemplate.update("insert into users (name, username, password) VALUES (?, ?, ?)",
                    name, username, encryptedPassword);
        } catch (Exception e) {
            throw new RuntimeException("Error while encrypting password", e);
        }
    }
}
