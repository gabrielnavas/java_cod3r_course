package com.jdbc.postgres;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TestConnection {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        PersonDAO personDAO = new PersonDAO(connection);
        personDAO.createTable();

        Person gab = personDAO.insertPerson("gabriel");
        Person maria = personDAO.insertPerson("maria");
        Person joao = personDAO.insertPerson("joao");

        System.out.println(gab);
        System.out.println(maria);
        System.out.println(joao);

        personDAO.updateById(gab.getId(), new Person("josé"));

        Optional<Person> optionalPerson = personDAO.findPersonById(gab.getId());
        optionalPerson.ifPresent(System.out::println);

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
