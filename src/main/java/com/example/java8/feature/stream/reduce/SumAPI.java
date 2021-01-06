package com.example.java8.feature.stream.reduce;

import java.util.Arrays;
import java.util.List;

public class SumAPI {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                // reduce(初始值，BinaryOperator<T>)：Lambda反复结合每个元素，直到流被规约成一个值
                // 初始值：sum的初始值
                // BinaryOperator<T>：将两个元素结合起来产生的一个新值
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }
}
