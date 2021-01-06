package com.example.java8.feature.stream.collect;

import com.example.java8.bean.Dish;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningByAPI {

    public static void main(String[] args) {

        Map<Boolean, List<Dish>> partitionedDishes =
                Dish.dishes()
                        .stream()
                        .collect(
                                Collectors
                                        // 接受一个返回值为Boolean的函数，作为分区谓词
                                        .partitioningBy(Dish::isVegetarian));

        partitionedDishes
                .forEach(
                        (bool, list) -> System.out.println(
                                String.format("%s: \n%s",
                                        bool,
                                        list
                                                .stream()
                                                .map(dish -> dish.getName() + "\n")
                                                .collect(Collectors.joining()))));
    }
}
