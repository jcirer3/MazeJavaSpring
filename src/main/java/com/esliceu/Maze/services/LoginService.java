package com.esliceu.Maze.services;

import com.esliceu.Maze.dao.UserDAO;
import com.esliceu.Maze.model.User;
import com.esliceu.Maze.utils.Encrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class LoginService {
    @Autowired
    UserDAO userDAO;

    @Autowired
    Encrypter encrypter;

    public User authenticate(String username, String password) throws NoSuchAlgorithmException {
        String encrypedPassword = encrypter.encryptedString(password);
        return userDAO.findByUsernameAndPassword(username, encrypedPassword);
    }
}
