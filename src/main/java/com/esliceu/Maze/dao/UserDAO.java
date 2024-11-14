package com.esliceu.Maze.dao;

import com.esliceu.Maze.model.User;

public interface UserDAO {
    User findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
    void saveUser(String name, String username, String password);
}
