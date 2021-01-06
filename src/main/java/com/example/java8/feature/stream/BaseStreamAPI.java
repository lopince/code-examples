package com.example.java8.feature.stream;

import com.example.java8.bean.Dish;

import java.util.List;

public abstract class BaseStreamAPI {

    protected static List<Dish> dishes = Dish.dishes();
}
