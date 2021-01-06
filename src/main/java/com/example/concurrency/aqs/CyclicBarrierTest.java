package com.example.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 多个线程之间的互相等待
@Slf4j
public class CyclicBarrierTest {

    // 初始化N个屏障
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(
            10,

            // 回调函数
            // 当所有屏障移除后，会执行该函数
            () -> log.info("cyclic is removed"));

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            executor.execute(() -> {
                try {
                    race(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private static void race(int threadNum) throws Exception {
        Thread.sleep(1000);
        log.info("{} is ready", threadNum);
        // 调用await()的方法后，会移除一个屏障
        // 且阻塞当前线程，直到所有屏障都移除

        // 多个线程之间的互相等待
        cyclicBarrier.await();

        log.info("{} continue", threadNum);
    }
}
