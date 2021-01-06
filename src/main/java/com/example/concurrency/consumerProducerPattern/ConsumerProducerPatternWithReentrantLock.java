package com.example.concurrency.consumerProducerPattern;

import com.example.util.LangUtils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerProducerPatternWithReentrantLock {

    private static int count = 0;
    private static final int MAX = 10;

    private static Lock lock = new ReentrantLock();

    // consumer 的等待条件。相当于一个读锁
    private static Condition notEmpty = lock.newCondition();

    // provider 的等待条件。相当于一个写锁
    private static Condition notFull = lock.newCondition();

    public static void main(String[] args) {

        LangUtils.newThreadThenStart(new Producer());
        LangUtils.newThreadThenStart(new Producer());
        LangUtils.newThreadThenStart(new Consumer());
        LangUtils.newThreadThenStart(new Producer());
//        LangUtils.newThreadThenStart(new Consumer());
    }

    private static class Producer implements Runnable {

        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {

                LangUtils.sleepRandom(3);

                lock.lock();

                while (count == MAX) {
                    try {
                        // 等待写锁
                        notFull.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                count++;
                System.out.println(String.format("[Producer %s] Produced, count: %s", Thread.currentThread().getId(), count));

                // 唤醒被读锁阻塞的对象
                notEmpty.signal();

                lock.unlock();
            }
        }
    }

    private static class Consumer implements Runnable {

        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {

                LangUtils.sleepRandom(3);

                lock.lock();

                while (count == 0){
                    try{
                        notEmpty.await();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

                count--;
                System.out.println(String.format("[Consumer %s] Consumed, count: %s", Thread.currentThread().getId(), count));

                notFull.signal();

                lock.unlock();
            }
        }
    }
}
