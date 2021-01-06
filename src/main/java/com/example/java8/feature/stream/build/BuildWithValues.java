package com.example.java8.feature.stream.build;

import java.util.stream.Stream;

public class BuildWithValues {

    public static void main(String[] args) {

        Stream<String> stringStream = Stream.of("Java8", "Lambdas", "In", "Actions");
        stringStream
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
