package com.example.java8.feature.stream.collect;

import com.example.java8.bean.Dish;

import java.util.Optional;
import java.util.stream.Collectors;

public class ReducingAPI {

    public static void main(String[] args) {

        // 所有收集器，都可以用reducing工厂方法定义规约过程

        // sum
        int totalCalories =
                Dish.dishes()
                        .stream()
                        .collect(Collectors.reducing(

                                // 归约操作的起始值
                                // 创建一个基于起始值的累加器
                                0,

                                // 对每个元素，应用转换函数
                                Dish::getCalories,

                                // BinaryOperator，二元操作符
                                // 将两个元素累积成一个同类型的元素
                                // 对流中的结果不断迭代合并起来
                                (i, j) -> i + j
                        ));

        // max
        Optional<Dish> mostCalorieDish =
                Dish.dishes()
                        .stream()
                        .collect(Collectors.reducing(
                                (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2
                        ));
    }
}
