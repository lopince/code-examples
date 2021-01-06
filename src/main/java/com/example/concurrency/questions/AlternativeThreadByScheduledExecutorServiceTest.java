package com.example.concurrency.questions;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AlternativeThreadByScheduledExecutorServiceTest {

    private static final Object object = new Object();

    public static void main(String[] args) {

        // 定期循环执行
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        executorService.scheduleAtFixedRate(
                () -> System.out.println("thread_1"),
                // 初始延迟
                0,
                // 执行间隔
                2,
                TimeUnit.SECONDS);

        executorService.scheduleAtFixedRate(
                () -> System.out.println("thread_2"),
                2,
                2,
                TimeUnit.SECONDS);
    }
}
