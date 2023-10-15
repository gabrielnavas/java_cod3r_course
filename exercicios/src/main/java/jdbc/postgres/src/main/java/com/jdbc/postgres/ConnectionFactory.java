package com.jdbc.postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static Connection connection = null;

    private ConnectionFactory() {}

    public static Connection getConnection() {
        if(connection != null) {
            return connection;
        }

        final String url = "jdbc:postgresql://localhost:5433/postgres";
        final String username = "postgres";
        final String password = "postgres123";

        try {
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        }
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    public static void closeConnection()  {
        try {
            connection.close();
        }
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
