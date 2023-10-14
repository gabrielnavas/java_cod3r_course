package com.jdbc.postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {
    public static void main(String[] args) throws SQLException {
        final String url = "jdbc:postgresql://localhost:5436/postgres";
        final String username = "postgres";
        final String password = "postgres123";

        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();
        statement.execute("""
        CREATE TABLE IF NOT EXISTS person (
            id serial primary key,
            name varchar(255)
        );      
        """);
        statement.execute("""
        DROP TABLE IF EXISTS person;
        """);
        System.out.println("table person created");

        connection.close();
    }
}
