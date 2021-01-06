package com.example.concurrency.bean;

import lombok.Data;

@Data
public class Person {

    private String name;

    private Integer age;

    private Double weight;

    public Person() {
        this.name = "John";
        this.age = 0;
        this.weight = 0.0;
    }
}
