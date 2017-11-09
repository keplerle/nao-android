package com.example.kinma.test_call_ws.model;

/**
 * Created by kinma on 23/10/2017.
 */

public class Person {
    private int id;
    private String name;
    private int age;

    public Person() {
        super();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
