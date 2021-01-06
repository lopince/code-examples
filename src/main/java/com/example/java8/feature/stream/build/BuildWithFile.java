package com.example.java8.feature.stream.build;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class BuildWithFile {

    public static void main(String[] args) {

        try (Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {

            long uniqueWords = lines
                    // 扁平化，将各个单词流转换成同一个流
                    .flatMap(
                            line ->
                                    // 一行一个单词流
                                    Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
