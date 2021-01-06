package com.example.java8.feature.stream.build;

import java.util.stream.Stream;

public class BuildWithFunction {

    public static void main(String[] args) {

        // 顺序迭代Lambda，对每个新生值应用函数
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        // 每次应用generate中的方法，生成一个新的值（无状态）
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }
}
