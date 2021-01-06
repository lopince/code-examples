package com.example.java8.feature.stream.map;

import java.util.Arrays;
import java.util.List;

public class FlatMapAPI {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("Goodbye", "World");

        words.stream()

                // 将字符串分割成单个字符，但此时返回的是stream<String[]>
                .map(w -> w.split(""))

                // 扁平化一个流
                // stream<String[]> --> stream<String>
                // flatMap让一个流中的每个值都转成一个流，再把所有流合并成一个流
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);
    }
}
