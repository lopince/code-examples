package com.example.concurrency.questions;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AlternativeThreadByReentrantLockAndConditionTest {

    private static final Object object = new Object();

    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static Condition condition1 = reentrantLock.newCondition();
    private static Condition condition2 = reentrantLock.newCondition();

    public static void main(String[] args) {

        Thread thread_1 = new Thread(() -> {
            while (true) {
                try {
                    reentrantLock.lock();

                    System.out.println("thread_1");

                    // thread_1: 运行状态 -> 阻塞等待
                    condition1.await();

                    // thread_2: 阻塞等待 -> 唤醒状态
                    condition2.signal();

                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        });

        Thread thread_2 = new Thread(() -> {
            while (true) {
                try {
                    reentrantLock.lock();

                    System.out.println("thread_2");

                    // thread_1: 阻塞等待 -> 唤醒状态
                    condition1.signal();

                    // thread_2: 运行状态 -> 阻塞等待
                    // 并释放当前占有的锁
                    condition2.await();

                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        });

        thread_1.start();
        thread_2.start();
    }
}
