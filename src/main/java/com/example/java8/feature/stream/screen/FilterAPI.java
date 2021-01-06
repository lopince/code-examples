package com.example.java8.feature.stream.screen;

import com.example.java8.bean.Dish;
import com.example.java8.feature.stream.BaseStreamAPI;

import java.util.List;
import java.util.stream.Collectors;

public class FilterAPI extends BaseStreamAPI {

    public static void main(String[] args) {

        List<Dish> vegetarianMenu =
                dishes
                        .stream()

                        // 接收方法引用，接收一个返回值为boolean的函数
                        .filter(Dish::isVegetarian)
                        .collect(Collectors.toList());

        vegetarianMenu.forEach(System.out::println);
    }
}
