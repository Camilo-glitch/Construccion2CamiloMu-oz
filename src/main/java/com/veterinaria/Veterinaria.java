package com.veterinaria;

import com.veterinaria.connectionDB.Connection;
import com.veterinaria.view.LoginMenu;

public class Veterinaria {

    public static void main(String[] args) throws Exception {
        Connection.getConnection();
        LoginMenu loginMenu = new LoginMenu();
    }

}
