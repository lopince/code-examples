package com.example.java8.feature.stream.map;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArraysStreamAPI {

    public static void main(String[] args) {

        String[] wordsArray = {"Goodbye", "World"};

        // Arrays.stream()，可以接受一个数组并产生对应数组元素的流
        Stream<String> wordsStream = Arrays.stream(wordsArray);
    }
}
