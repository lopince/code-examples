package com.example.java8.feature.stream.build;

import java.util.Arrays;

public class BuildWithArray {

    public static void main(String[] args) {

        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();
    }
}
