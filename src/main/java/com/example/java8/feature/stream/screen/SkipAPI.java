package com.example.java8.feature.stream.screen;

import com.example.java8.feature.stream.BaseStreamAPI;

public class SkipAPI extends BaseStreamAPI {

    public static void main(String[] args) {

        dishes.stream()
                .filter(d -> d.getCalories() > 300)

                // 返回一个扔掉了前n个元素的流
                // 如果流中元素不足n个，则返回一个空流
                .skip(2)
                .forEach(System.out::println);
    }
}
