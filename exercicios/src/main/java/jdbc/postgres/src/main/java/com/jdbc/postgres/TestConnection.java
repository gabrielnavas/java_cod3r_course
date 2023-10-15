package com.jdbc.postgres;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestConnection {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        PersonDAO personDAO = new PersonDAO(connection);
        personDAO.createTable();
        personDAO.insertPerson("gabriel");
        personDAO.insertPerson("maria");
        personDAO.insertPerson("joao");
        personDAO.insertPerson("mario");
        personDAO.insertPerson("julia");
        personDAO.insertPerson("kika");
        List<Person> persons = personDAO.findAllPersons();
        for (Person person : persons) {
            System.out.println(person);
            personDAO.deleteById(person.getId());
        }

        persons = personDAO.findAllPersons();
        if(persons.size() == 0) {
            System.out.println("all persons are deleted");
        }
        personDAO.closeConnection();
    }
}
