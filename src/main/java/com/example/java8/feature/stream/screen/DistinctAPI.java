package com.example.java8.feature.stream.screen;

import com.example.java8.feature.stream.BaseStreamAPI;

import java.util.Arrays;
import java.util.List;

public class DistinctAPI extends BaseStreamAPI {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);

        numbers.stream()
                .filter(i -> i % 2 == 0)

                // 返回一个元素各异的流
                .distinct()
                .forEach(System.out::println);
    }
}
