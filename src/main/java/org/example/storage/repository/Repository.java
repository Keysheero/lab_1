package org.example.storage.repository;

import java.sql.Connection;

public class Repository {
    public Connection connection;

    public Repository(Connection connection) {
        this.connection = connection;
    }
}
