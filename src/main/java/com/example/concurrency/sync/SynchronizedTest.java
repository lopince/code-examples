package com.example.concurrency.sync;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedTest {

    public void syncCodeBlock() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("syncCodeBlock - {}", i);
            }
        }
    }

    public synchronized void syncMethod() {
            for (int i = 0; i < 10; i++) {
                log.info("syncMethod - {}", i);
            }
    }

    public static void main(String[] args) {
        SynchronizedTest test = new SynchronizedTest();
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(test::syncCodeBlock);
        executorService.execute(test::syncMethod);
    }
}
