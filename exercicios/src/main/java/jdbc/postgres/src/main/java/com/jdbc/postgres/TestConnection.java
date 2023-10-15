package com.jdbc.postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        PersonDAO personDAO = new PersonDAO(connection);
        personDAO.createTable();
        personDAO.insertPerson("gabriel");
        personDAO.closeConnection();
    }
}
