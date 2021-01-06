package com.example.java8.feature.stream.map;

import com.example.java8.bean.Dish;

public class BaseTypeMapAPI {

    public static void main(String[] args) {

        int calories = Dish.dishes().stream()
                .mapToInt(Dish::getCalories)
                .sum();
    }
}
