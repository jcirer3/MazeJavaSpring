package com.esliceu.Maze.services;

import com.esliceu.Maze.dao.UserDAO;
import com.esliceu.Maze.model.User;
import com.esliceu.Maze.utils.Encrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    UserDAO userDAO;

    @Autowired
    Encrypter encrypter;

    public boolean authenticate(String username, String password) {
        User user = userDAO.findByUsername(username);
        if (user == null) {
            return false;
        }
        try {
            String hashedPassword = encrypter.encryptedString(password);
            return hashedPassword.equals(user.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
