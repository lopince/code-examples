package com.example.java8.feature.stream.numerical;

import java.util.stream.IntStream;

public class RangeAPI {

    public static void main(String[] args) {

        // 从1到100的偶数流
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
    }
}
