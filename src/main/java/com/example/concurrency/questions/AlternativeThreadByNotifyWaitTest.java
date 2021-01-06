package com.example.concurrency.questions;

import java.util.concurrent.Executors;

public class AlternativeThreadByNotifyWaitTest {

    private static final Object object = new Object();

    public static void main(String[] args) {

        Thread thread_1 = new Thread(() -> {
            while (true){

                // 通过synchronized关键字，获取锁
                synchronized (object) {
                    try {
                        System.out.println("thread_1");

                        // 唤醒其他等待线程，并使其他线程尝试去获取锁（当前线程并不释放锁）
                        object.notify();

                        // 当前线程阻塞，并释放锁
                        object.wait();

                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread_2 = new Thread(() -> {
            while (true){
                synchronized (object) {
                    try {
                        System.out.println("thread_2");
                        object.notify();

                        object.wait();

                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread_1.start();
        thread_2.start();
    }
}
