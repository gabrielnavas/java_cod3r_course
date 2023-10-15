package com.jdbc.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonDAO {

    private Connection connection;

    public PersonDAO(Connection connection) {
        this.connection = connection;
    }

    public void createTable() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("""
        CREATE TABLE IF NOT EXISTS person (
            id serial primary key,
            name varchar(255)
        );   
        """);
        System.out.println("table person created");
    }

    public void insertPerson(String name) throws SQLException {
        String sql = "INSERT INTO person (name) values (?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.execute();
    }

    public void closeConnection() throws SQLException {
        this.connection.close();
    }
}
