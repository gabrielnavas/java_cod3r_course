package com.jdbc.postgres;

public class Person {

    private int id;
    private String name;

    public Person() {
        this(0, "");
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(String name) {
        this(0, name);
    }

    @Override
    public String toString() {
        return String.format("%d:%s", id, name);
    }

    public int getId() {
        return id;
    }
}
