package com.veterinaria.connectionDB;

import java.util.List;

public class ActionsDB {
    public static void insert(String table, String[] columns, String[] values) {
        StringBuilder query = new StringBuilder("INSERT INTO " + table + " (");
        for (int i = 0; i < columns.length; i++) {
            query.append(columns[i]);
            if (i < columns.length - 1) {
                query.append(", ");
            }
        }
        query.append(") VALUES (");
        for (int i = 0; i < values.length; i++) {
            query.append("'").append(values[i]).append("'");
            if (i < values.length - 1) {
                query.append(", ");
            }
        }
        query.append(")");
        try {
            java.sql.Statement statement = com.veterinaria.connectionDB.Connection.getConnection().createStatement();
            statement.executeUpdate(query.toString());
            com.veterinaria.connectionDB.Connection.closeConnection();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void update(String table, String[] columns, String[] values, String condition) {
        System.out.println("UPDATE");
        StringBuilder query = new StringBuilder("UPDATE " + table + " SET ");
        for (int i = 0; i < columns.length; i++) {
            query.append(columns[i]).append(" = '").append(values[i]).append("'");
            if (i < columns.length - 1) {
                query.append(", ");
            }
        }
        System.out.println(query);
        query.append(" WHERE ").append(condition);
        try {
            java.sql.Statement statement = com.veterinaria.connectionDB.Connection.getConnection().createStatement();
            statement.executeUpdate(query.toString());
            System.out.println("Registro actualizado correctamente");
            com.veterinaria.connectionDB.Connection.closeConnection();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void delete(String table, String condition) {
        String query = "DELETE FROM " + table + " WHERE " + condition;
        try {
            java.sql.Statement statement = com.veterinaria.connectionDB.Connection.getConnection().createStatement();
            statement.executeUpdate(query);
            com.veterinaria.connectionDB.Connection.closeConnection();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static java.sql.ResultSet select(String table, String[] columns, String condition) {
        String query = "SELECT ";
        for (int i = 0; i < columns.length; i++) {
            query += columns[i];
            if (i < columns.length - 1) {
                query += ", ";
            }
        }
        query += " FROM " + table;
        if (condition != null) {
            query += " WHERE " + condition;
        }
        try {
            java.sql.Statement statement = com.veterinaria.connectionDB.Connection.getConnection().createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    // Listamos todos los datos de cualquier tabla
    public List<String> selectAll(String table) {
        String query = "SELECT * FROM " + table;
        try {
            java.sql.Statement statement = com.veterinaria.connectionDB.Connection.getConnection().createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(query);
            List<String> data = new java.util.ArrayList<>();
            while (resultSet.next()) {
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    data.add(resultSet.getString(i));
                }
            }
            com.veterinaria.connectionDB.Connection.closeConnection();
            return data;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
}
