package com.example.concurrency.aqs;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.*;

public class CallableAndCountDownLatch {

    public static void main(String[] args) throws Exception {

        CountDownLatch countDownLatch = new CountDownLatch(5);

        Task task1 = new Task(countDownLatch, "task1", 1);
        Task task2 = new Task(countDownLatch, "task2", 2);
        Task task3 = new Task(countDownLatch, "task3", 3);
        Task task4 = new Task(countDownLatch, "task4", 4);
        Task task5 = new Task(countDownLatch, "task5", 5);

        List<Future<Boolean>> futureList = Lists.newArrayList();
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        futureList.add(cachedThreadPool.submit(task1));
        futureList.add(cachedThreadPool.submit(task2));
        futureList.add(cachedThreadPool.submit(task3));
        futureList.add(cachedThreadPool.submit(task4));
        futureList.add(cachedThreadPool.submit(task5));
        System.out.println("Submitted task");
        System.out.println();

        System.out.println("countDownLatch.await()");
        countDownLatch.await();

        System.out.println("countDownLatch done");
        System.out.println();
        System.out.println("getting result from future list");
        for (Future<Boolean> future : futureList) {
            System.out.println(future.get());
        }
    }

    private static class Task implements Callable<Boolean> {

        private CountDownLatch countDownLatch;
        private String value;
        private int sleepSec;

        public Task(CountDownLatch countDownLatch, String value, int sleepSec) {
            this.countDownLatch = countDownLatch;
            this.value = value;
            this.sleepSec = sleepSec;
        }

        @Override
        public Boolean call() throws Exception {

            System.out.println(String.format("%s start sleep: %ss", value, sleepSec * 1000));
            Thread.sleep(sleepSec * 1000);
            System.out.println(String.format("%s end sleep", value));

            countDownLatch.countDown();

            return sleepSec % 2 == 0;
        }
    }
}
