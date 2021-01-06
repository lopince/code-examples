package com.example.java8.feature.stream.collect;

import com.example.java8.bean.Dish;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

public class SummarizingIntAPI {

    public static void main(String[] args) {

        IntSummaryStatistics intSummaryStatistics =
                Dish.dishes()
                        .stream()
                        .collect(Collectors.summarizingInt(Dish::getCalories));

        System.out.println("intSummaryStatistics.getAverage(): " + intSummaryStatistics.getAverage());
        System.out.println("intSummaryStatistics.getCount(): " + intSummaryStatistics.getCount());
        System.out.println("intSummaryStatistics.getMax(): " + intSummaryStatistics.getMax());
        System.out.println("intSummaryStatistics.getMin(): " + intSummaryStatistics.getMin());
        System.out.println("intSummaryStatistics.getSum(): " + intSummaryStatistics.getSum());
    }
}
