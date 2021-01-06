package com.example.java8.feature.stream.screen;

import com.example.java8.feature.stream.BaseStreamAPI;

public class LimitAPI extends BaseStreamAPI {

    public static void main(String[] args) {

        dishes.stream()
                .filter(dish -> dish.getCalories() > 300)

                // 如果流是有序的，则最多返回前n个元素（流是否有序，取决于源的数据结构）
                // 无序流则返回无序结果
                .limit(3)
                .forEach(System.out::println);
    }
}
