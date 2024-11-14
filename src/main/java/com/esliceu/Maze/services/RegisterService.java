package com.esliceu.Maze.services;

import com.esliceu.Maze.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    UserDAO userDAO;

    public void saveUser(String name, String username, String password) {
        userDAO.saveUser(name, username, password);
    }
}
