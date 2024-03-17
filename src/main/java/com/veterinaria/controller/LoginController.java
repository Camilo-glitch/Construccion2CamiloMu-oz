package com.veterinaria.controller;

import com.veterinaria.model.Person;
import lombok.extern.java.Log;

@Log
public class LoginController {
    UserController userController = new UserController();
    public boolean existUser(String username, String password) {
        // Validamos si el usuario y contraseña son correctos y retornamos true si es correcto
        for (Person person : userController.getAllPersons()) {
            if (person.getUsername().equals(username) && person.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

}
