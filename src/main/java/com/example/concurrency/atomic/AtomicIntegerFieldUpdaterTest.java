package com.example.concurrency.atomic;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Slf4j
public class AtomicIntegerFieldUpdaterTest {

    private static AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdaterTest> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterTest.class, "count");

    @Getter
    public volatile int count = 100;

    private static AtomicIntegerFieldUpdaterTest test = new AtomicIntegerFieldUpdaterTest();

    public static void main(String[] args) {
        if (updater.compareAndSet(test, 100, 120)){
            log.info("update success, count:{}", test.getCount());
        }else {
            log.info("update failed, count:{}", test.getCount());
        }
    }
}
