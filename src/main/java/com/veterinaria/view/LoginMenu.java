package com.veterinaria.view;

import com.veterinaria.controller.LoginController;
import com.veterinaria.controller.UserController;
import com.veterinaria.model.Person;
import com.veterinaria.utils.Role;

import java.util.Scanner;

public class LoginMenu {
    private final LoginController loginController = new LoginController();
    private final UserController userController = new UserController();
    private int optionSelectedByUser = 0;
    Scanner sc = new Scanner(System.in);

    public LoginMenu() throws Exception {
        showLoginMenu();
    }

    public int showLoginMenu() throws Exception {
        System.out.print("""
                --- INICIO SESIÓN ---
                
                1. Iniciar sesión
                2. Registrarse
                3. Salir
                
                Elija una opción: 
                """);
        try {
            optionSelectedByUser = sc.nextInt();
            if (optionSelectedByUser < 1 || optionSelectedByUser > 3) {
                throw new Exception("Error: Debe ingresar un número entre 1 y 3");
            } else {
                showLoginMenuOptions();
            }
        } catch (Exception e) {
            throw new Exception("Error: Debe ingresar un número entero");
        }
        return optionSelectedByUser;
    }

    public void showLoginMenuOptions() {
        switch (optionSelectedByUser) {
            case 1 -> login();
            case 2 -> register();
            case 3 -> System.exit(0);
        }
    }

    private void login() {
        System.out.print("Ingrese su usuario: ");
        String username = sc.next();
        System.out.print("Ingrese su contraseña: ");
        String password = sc.next();

        try {
            if (username.isEmpty() || password.isEmpty()) {
                throw new Exception("Error: El usuario y contraseña no pueden estar vacíos");
            } else {
                if (loginController.existUser(username, password)) {
                    System.out.println("Inicio de sesión exitoso");
                    UserController.currentPerson = userController.findPerson(username, password);
                    MainMenu mainMenu = new MainMenu();

                } else {
                    throw new Exception("Error: Usuario o contraseña incorrectos");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al iniciar sesión: " + e);
        }
    }

    private Person register() {
        System.out.print("Ingrese su número de cédula");
        long id = sc.nextLong();
        System.out.print("Ingrese su nombre: ");
        String name = sc.next();
        System.out.print("Ingrese su edad: ");
        int age = sc.nextInt();
        String role = String.valueOf(Role.CLIENT);

        try {
            if (name.isEmpty() || age < 0) {
                throw new Exception("Error: El nombre no puede estar vacío y la edad debe ser mayor a 0");
            } else {
                System.out.print("Registro exitoso");
                return userController.savePersonClient(id, name, age, role);
            }
        } catch (Exception e) {
            System.out.println("Error al registrarse: " + e);
            return userController.savePersonClient(id,name, age, role);
        }
    }
}
