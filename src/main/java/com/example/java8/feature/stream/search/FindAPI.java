package com.example.java8.feature.stream.search;

import com.example.java8.bean.Dish;
import com.example.java8.feature.stream.BaseStreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindAPI extends BaseStreamAPI {

    public static void main(String[] args) {

        Optional<Dish> dish =
                dishes.stream()
                        .filter(Dish::isVegetarian)

                        // 返回当前流中的任意元素
                        .findAny();

        // 值存在时，执行指定代码块
        dish.ifPresent(d ->
                System.out.println(d.getName())
        );

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                        .map(x -> x * x)
                        .filter(x -> x % 3 == 0)

                        // 返回第一个出现的元素
                        // 找到第一个元素，在并行时，会有很多限制
                        .findFirst(); // 9
    }
}
