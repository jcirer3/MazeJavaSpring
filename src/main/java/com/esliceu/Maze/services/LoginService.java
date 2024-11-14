package com.esliceu.Maze.services;

import com.esliceu.Maze.dao.UserDAO;
import com.esliceu.Maze.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    UserDAO userDAO;

    public boolean authenticate(String username, String password) {
        User user = userDAO.findByUsername(username);
        if (user != null && user.getPassword().equals(password)){
            return true;
        }
        return false;
    }
}
