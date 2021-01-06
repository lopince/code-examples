package com.example.java8.feature.stream.collect;

import com.example.java8.bean.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MultiLevelGroupingByAPI {

    public static void main(String[] args) {

        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
                Dish.dishes()
                        .stream()
                        .collect(
                                Collectors.groupingBy(

                                        // 一级分类函数
                                        Dish::getType,

                                        // 二级分类函数（二层收集器）
                                        Collectors.groupingBy(dish -> {
                                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                            else return CaloricLevel.FAT;
                                        })));


        // 按子组收集数据
        Map<Dish.Type, Long> typesCount =
                Dish.dishes()
                        .stream()
                        .collect(
                                Collectors.groupingBy(
                                        Dish::getType,
                                        Collectors.counting()));

        Map<Dish.Type, Optional<Dish>> mostCaloricByType =
                Dish.dishes()
                        .stream()
                        .collect(
                                Collectors.groupingBy(
                                        Dish::getType,
                                        Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))));

        // 把收集器结果转换成另一种类型
        Map<Dish.Type, Dish> mostCaloricByTypeWithRawType =
                Dish.dishes()
                        .stream()
                        .collect(Collectors.groupingBy(
                                Dish::getType,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)),

                                        // 把收集器返回的结果转换成另一种类型
                                        // reducing收集器永远都不会返回 Optional.empty()
                                        Optional::get)));
    }

    public enum CaloricLevel {DIET, NORMAL, FAT}

}
