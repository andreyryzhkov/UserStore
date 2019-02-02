package com.aryzhkov.userstore.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConnection {

    public static Connection getConnection() {
        Properties properties = PropertiesConnection.getProperties();
        try {
            return DriverManager.getConnection(properties.getProperty("db.url"),
                    properties.getProperty("db.username"),
                    properties.getProperty("db.password"));
        } catch (SQLException e) {
            throw new RuntimeException("Connection failed", e);
        }
    }
}
