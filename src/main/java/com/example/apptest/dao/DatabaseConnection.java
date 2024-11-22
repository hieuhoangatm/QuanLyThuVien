package com.example.apptest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/qltv";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";


    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            if (connection != null) {
                System.out.println("Connection to the database established successfully.");
            } else {
                throw new SQLException("Failed to establish a connection to the database.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL driver not found.");
            e.printStackTrace();
            throw new SQLException("MySQL driver not found", e);
        } catch (SQLException e) {
            System.out.println("Error establishing connection to the database.");
            e.printStackTrace();
            throw e;
        }
        return connection;
    }
}
