package org.example.storage.repository.postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5455/lab2db";
    private static final String USER = "keysheero";
    private static final String PASSWORD = "keysheeropassword";


    public  Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
