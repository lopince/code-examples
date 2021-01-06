package com.example.concurrency.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorTest {

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(2);
    }
}
