package com.jdbc.postgres;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Person> findAllPersons() throws SQLException {
        List<Person> persons = new ArrayList<>();

        String sql = "SELECT id, name FROM person;";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rset = pstmt.executeQuery();
        while(rset.next()) {
            Person person = new Person(
                    rset.getInt("id"),
                    rset.getString("name")
            );
            persons.add(person);
        }
        return persons;
    }

    public void deleteById(int id) throws SQLException {
        String sql = "DELETE FROM person WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, id);
        if(pstmt.execute()) {
            throw  new RuntimeException(String.format("problem on delete person with id %s", id));
        }
    }

    public void closeConnection() throws SQLException {
        this.connection.close();
    }
}
