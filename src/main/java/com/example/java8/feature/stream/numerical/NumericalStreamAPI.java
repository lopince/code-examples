package com.example.java8.feature.stream.numerical;

import com.example.java8.bean.Dish;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericalStreamAPI {

    public static void main(String[] args) {

        // 映射到原始类型数值流
        int carlories = Dish.dishes()
                .stream()
                .mapToInt(Dish::getCalories)
                .sum();

        // 转换回对象流
        IntStream intStream = Dish.dishes()
                .stream()
                .mapToInt(Dish::getCalories);
        Stream<Integer> integerStream = intStream.boxed();

        // 默认值
        OptionalInt maxCalories = Dish.dishes()
                .stream()
                .mapToInt(Dish::getCalories)

                // 原始类型int，默认值时0。通过optional区分
                .max();
        int max = maxCalories.orElse(1);
    }
}
