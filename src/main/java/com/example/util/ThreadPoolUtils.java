package com.example.util;

import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUtils {

    private static ThreadPoolExecutor executor;

    static {
        executor = initExecutor();
    }

    public static void submit(Runnable task){

        executor.submit(task);
    }

    public static String getStatus() {
        return String.format("[ThreadPoolUtils] ThreadPool status: poolSize: %s, activeCount: %s, taskCount: %s",
                executor.getPoolSize(),
                executor.getActiveCount(),
                executor.getTaskCount());
    }

    private static ThreadPoolExecutor initExecutor() {

        return new ThreadPoolExecutor(
                1,
                2,
                60, TimeUnit.MINUTES,
                new SynchronousQueue<>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
    }
}
