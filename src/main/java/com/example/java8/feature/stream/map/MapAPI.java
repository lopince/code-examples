package com.example.java8.feature.stream.map;

import com.example.java8.bean.Dish;
import com.example.java8.feature.stream.BaseStreamAPI;

import java.util.List;
import java.util.stream.Collectors;

public class MapAPI extends BaseStreamAPI {

    public static void main(String[] args) {

        List<String> dishNames =
                dishes.stream()

                        // 映射，接受一个函数作为参数
                        // 把这个函数应用到每个元素中，并将其映射为一个新的元素
                        // 如此处，会返回一个Stream<String>
                        .map(Dish::getName)
                        .collect(Collectors.toList());

        dishNames.forEach(System.out::println);
    }
}
