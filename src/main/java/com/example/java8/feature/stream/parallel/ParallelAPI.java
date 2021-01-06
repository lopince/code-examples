package com.example.java8.feature.stream.parallel;

import java.util.Hashtable;
import java.util.stream.IntStream;

public class ParallelAPI {

    public static void main(String[] args) {

        int result = IntStream.rangeClosed(1, 100)

                // 调用parallel之后进行的所有操作都并行执行
                // 把流划分为小块来并行处理

                .parallel()
                .map(n -> n * 2)
                .sum();



        System.out.println(result);
    }
}
