package com.example.concurrency.consumerProducerPattern;

import com.example.util.LangUtils;

public class ConsumerProducerPatternWithWaitNotify {

    private static final Integer MAX = 10;

    private static int count = 0;
    private static Object lock = new Object();

    public static void main(String[] args) {

        LangUtils.newThreadThenStart(new Producer());
        LangUtils.newThreadThenStart(new Producer());
        LangUtils.newThreadThenStart(new Producer());
        LangUtils.newThreadThenStart(new Consumer());
    }

    private static class Producer implements Runnable {

        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {

                LangUtils.sleep(1000);

                synchronized (lock) {

                    while (count == MAX) {

                        try {
                            lock.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    count++;
                    System.out.println(String.format("[Producer %s] Produced, count: %s", Thread.currentThread().getId(), count));

                    lock.notifyAll();
                }
            }
        }
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {

                LangUtils.sleep(1000);

                synchronized (lock) {

                    while (count == 0) {

                        try {
                            lock.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    count--;
                    System.out.println(String.format("[Consumer %s] Consumed, count: %s", Thread.currentThread().getId(), count));

                    lock.notifyAll();
                }
            }
        }
    }
}
