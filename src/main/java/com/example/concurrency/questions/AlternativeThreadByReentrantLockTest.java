package com.example.concurrency.questions;

import java.util.concurrent.locks.ReentrantLock;

public class AlternativeThreadByReentrantLockTest {

    private static ReentrantLock reentrantLock = new ReentrantLock(true);

    public static void main(String[] args) {


        Thread thread_1 = new Thread(() -> {
            while (true) {
                try {
                    reentrantLock.lock();
                    System.out.println("thread_1");

                    Thread.sleep(10);
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

                    Thread.sleep(10);
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
