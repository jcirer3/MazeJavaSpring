package com.esliceu.Maze.services;

import com.esliceu.Maze.dao.UserDAO;
import com.esliceu.Maze.exceptions.PasswordToShortException;
import com.esliceu.Maze.exceptions.UserAlreadyExistException;
import com.esliceu.Maze.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    UserDAO userDAO;

    public void saveUser(String name, String username, String password) throws UserAlreadyExistException, PasswordToShortException {
        if (validaUser(username) && validaPassword(password)){
            userDAO.saveUser(name, username, password);
        } else {
            System.out.println("Error, no se ha creado el usuario");
        }
    }
    public boolean validaPassword(String password) throws PasswordToShortException {
        if (password == null || password.length() < 5) {
            throw new PasswordToShortException("La contrasenya és massa curta. Ha de tenir mínim 5 caràcters.");
        }
        System.out.println("es true password");
        return true;
    }

    public boolean validaUser(String username) throws UserAlreadyExistException {
        User user = userDAO.findByUsername(username);
        if (user != null && user.getUsername() != null) {
            throw new UserAlreadyExistException("El nom d'usuari ja existeix.");
        }
        return true;
    }
}
