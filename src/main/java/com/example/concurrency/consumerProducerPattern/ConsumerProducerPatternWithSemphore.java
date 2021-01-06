package com.example.concurrency.consumerProducerPattern;

import com.example.util.LangUtils;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class ConsumerProducerPatternWithSemphore {

    private static final int max = 10;

    private static int count = 0;

    private static Semaphore mutex = new Semaphore(1);
    private static Semaphore vacancies = new Semaphore(10);
    private static Semaphore product = new Semaphore(0);

    public static void main(String[] args) {

        LangUtils.newThreadThenStart(new Producer());
        LangUtils.newThreadThenStart(new Producer());
        LangUtils.newThreadThenStart(new Producer());

        LangUtils.newThreadThenStart(new Consumer());
    }

    private static class Producer implements Runnable {
        @Override
        public void run() {
            LangUtils.loop(
                    10,
                    () -> {
                        LangUtils.sleepRandom(3);

                        try {
                            mutex.acquire();
                            vacancies.acquire();

                            count++;
                            System.out.println(String.format("[Producer %s] Produced, count: %s", Thread.currentThread().getId(), count));

                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            product.release();
                            mutex.release();
                        }
                    });
        }
    }

    private static class Consumer implements Runnable {
        @Override
        public void run() {

            LangUtils.loop(
                    10,
                    () -> {

                        try {
                            mutex.acquire();
                            product.acquire();

                            count--;
                            System.out.println(String.format("[Consumer %s] Consumed, count: %s", Thread.currentThread().getId(), count));

                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            vacancies.release();
                            mutex.release();
                        }
                    }
            );
        }
    }
}
