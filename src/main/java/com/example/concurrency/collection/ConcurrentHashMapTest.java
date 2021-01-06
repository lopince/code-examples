package com.example.concurrency.collection;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put(null, "null");
        System.out.println(map.get(null));
    }
}
