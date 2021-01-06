package com.example.concurrency.threadPool;

import com.example.util.LangUtils;
import com.example.util.ThreadPoolUtils;

public class ThreadPoolTest {

    public static void main(String[] args) throws Exception{

        System.out.println(ThreadPoolUtils.getStatus());

        Thread thread1 = new Thread(() -> {
            System.out.println("Running thread: " + Thread.currentThread().getId());
            LangUtils.sleep(2000);
            System.out.println("Done thread: " + Thread.currentThread().getId());
        });
        ThreadPoolUtils.submit(thread1);
        System.out.println(ThreadPoolUtils.getStatus());

        Thread thread2 = new Thread(() -> {
            System.out.println("Running thread: " + Thread.currentThread().getId());
            LangUtils.sleep(2000);
            System.out.println("Done thread: " + Thread.currentThread().getId());
        });
        ThreadPoolUtils.submit(thread2);
        System.out.println(ThreadPoolUtils.getStatus());

        thread1.join();
        thread2.join();

        thread1.interrupt();
        thread2.interrupt();

        System.out.println(thread1.isAlive());
        System.out.println(thread2.isAlive());

        while (true) {
            System.out.println(ThreadPoolUtils.getStatus());
            LangUtils.sleep(2000);
        }
    }
}
