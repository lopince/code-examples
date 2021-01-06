package com.example.java8.feature.stream;

import com.example.java8.bean.Dish;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 流：从支持数据处理操作的源生成的元素序列
 */
public class CommonStreamAPI extends BaseStreamAPI{

    public static void main(String[] args) {

        /**
         * 流操作实例
         *
         * 中间操作：返回另一个流
         *  1. filter
         *  2. map
         *  3. sorted
         *  4. limit
         *  5. distinct
         *
         * 终端操作：从流的流水线生成结果
         *  1. count：返回流中元素的个数
         *  2. collect：把流归约成一个集合
         *  3. forEach：消费流中的每一个元素并对其应用Lambda
         *
         */
        List<String> threeHighCaloricDishes =

                // 源
                dishes
                        /**
                         * 获取流
                         *
                         *  1. 流只能被消费一次
                         */
                        .stream()

                        // 从流中排除某些元素
                        .filter(dish -> dish.getCalories() > 300)

                        /**
                         * 将元素转换成其他形式或提取信息
                         *
                         * 1. 内部迭代
                         */
                        .map(Dish::getName)

                        // 截断流，使其元素不超过给定的数量
                        .limit(3)

                        // 将流转换为其他形式（此处转换为列表）
                        .collect(Collectors.toList());

        System.out.println(threeHighCaloricDishes);
    }
}
