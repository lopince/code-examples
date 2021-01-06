package com.example.java8.feature.stream.search;

import com.example.java8.bean.Dish;
import com.example.java8.feature.stream.BaseStreamAPI;

public class MatchAPI extends BaseStreamAPI {

    public static void main(String[] args) {

        // anyMatch：流中是否有一个元素能匹配给定谓词，返回一个boolean类型
        if (dishes.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("The dish is (somewhat) vegetarian friendly!");
        }

        // allMatch：流中是否都能匹配给定谓词，返回一个boolean类型
        if (dishes.stream().allMatch(dish -> dish.getName().length() < 1000)){
            System.out.println("All the dish name is shorter than 1000");
        }

        // allMatch：流中是否都能匹配给定谓词，返回一个boolean类型
        if (dishes.stream().noneMatch(dish -> dish.getCalories() < 100)){
            System.out.println("none of the dishes' calories is less than 100!");
        }
    }
}
