package com.example.concurrency.singleton;

import java.lang.reflect.Constructor;

public class ReflectDestroySingleton {

    public static void main(String[] args) throws Exception {

        EnumSingleton singleton1 = EnumSingleton.getInstance();

        Class clazz = EnumSingleton.class;
        Constructor<EnumSingleton> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        EnumSingleton singleton2 = constructor.newInstance();

        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
    }
}
