package com.example.java8.feature.stream.collect;

import com.example.java8.bean.Dish;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class MaxByAPI {

    public static void main(String[] args) {

        Optional<Dish> mostCalorieDish =
                Dish.dishes()
                        .stream()
                        .collect(
                                Collectors.maxBy(
                                        Comparator.comparingInt(Dish::getCalories)));

        mostCalorieDish.ifPresent(System.out::println);
    }
}
