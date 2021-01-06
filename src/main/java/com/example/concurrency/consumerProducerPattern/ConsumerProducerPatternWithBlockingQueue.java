package com.example.concurrency.consumerProducerPattern;

import com.example.util.LangUtils;

import java.util.concurrent.ArrayBlockingQueue;

public class ConsumerProducerPatternWithBlockingQueue {

    private static ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {

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
                            blockingQueue.put(1);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        System.out.println(String.format("[Producer %s] Produced, count: %s", Thread.currentThread().getId(), blockingQueue.size()));
                    });
        }
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {

            LangUtils.loop(
                    10,
                    () -> {
                        LangUtils.sleepRandom(3);

                        try {
                            Integer e = blockingQueue.take();
                            System.out.println(String.format("[Consumer %s] Consumed: %s, count: %s", Thread.currentThread().getId(), e, blockingQueue.size()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
            );
        }
    }
}
