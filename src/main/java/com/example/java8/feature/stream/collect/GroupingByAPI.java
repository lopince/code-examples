package com.example.java8.feature.stream.collect;

import com.example.java8.bean.Dish;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByAPI {

    public static void main(String[] args) {

        Map<Dish.Type, List<Dish>> dishesByType =
                Dish.dishes()
                        .stream()
                        .collect(
                                Collectors.groupingBy(

                                        // 分类函数，用来把流中的元素分成不同的组
                                        Dish::getType));
        System.out.println(dishesByType);

        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel =
                Dish.dishes()
                        .stream()
                        .collect(
                                Collectors.groupingBy(
                                        dish -> {
                                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                            else return CaloricLevel.FAT;
                                        }));
    }

    public enum CaloricLevel {DIET, NORMAL, FAT}
}
