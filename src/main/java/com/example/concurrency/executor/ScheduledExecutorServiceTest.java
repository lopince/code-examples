package com.example.concurrency.executor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class ScheduledExecutorServiceTest {

    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.schedule(new Runnable() {
                @Override
                public void run() {
                    log.info("task: {}", index);
                }
            }, 5, TimeUnit.SECONDS);
        }

        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                log.info("delay running");
            }
        }, 1, 3, TimeUnit.SECONDS);

//        executorService.shutdown();

    }
}
