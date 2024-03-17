package com.veterinaria.connectionDB;

public class Connection {
    private static final String URL = "jdbc:mysql://localhost:3306/veterinaria20241";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static java.sql.Connection connection = null;

    public static java.sql.Connection getConnection() {
        try {
            Class.forName(DRIVER);
            connection = java.sql.DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
