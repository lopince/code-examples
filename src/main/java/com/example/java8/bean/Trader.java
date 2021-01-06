package com.example.java8.bean;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class Trader {

    private String name;
    private String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    static Trader raoul = new Trader("Raoul", "Cambridge");
    static Trader mario = new Trader("Mario","Milan");
    static Trader alan = new Trader("Alan","Cambridge");
    static Trader brian = new Trader("Brian","Cambridge");

    public static List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);
}
