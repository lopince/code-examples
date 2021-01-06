package com.example.java8.feature.stream.collect;

import com.example.java8.bean.Dish;

import java.util.stream.Collectors;

public class CountingAPI {

    public static void main(String[] args) {
        System.out.println(
                Dish.dishes()
                        .stream()
                        .collect(Collectors.counting()));
    }
}
