package com.example.java8.feature.stream.collect;

import com.example.java8.bean.Dish;

import java.util.stream.Collectors;

public class JoiningAPI {

    public static void main(String[] args) {

        String menu = Dish.dishes()
                .stream()
                .map(d -> d.getName() + "\n")
                .collect(Collectors.joining());

        System.out.println("menu: \n" + menu);
    }
}
