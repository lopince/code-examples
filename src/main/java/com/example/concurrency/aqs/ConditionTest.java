package com.example.concurrency.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ConditionTest {

    public static void main(String[] args) {

        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

        new Thread(() -> {
            try {
                // 加入aqs等待序列
                reentrantLock.lock();
                log.info("wait signal"); // 1

                // 从aqs中移除，并加入condition队列，并等待condition信号
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("get signal"); // 4
            reentrantLock.unlock();
        }).start();

        new Thread(() -> {
            reentrantLock.lock();
            log.info("get lock"); // 2
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 唤醒其他线程，将其他线程转移回到aqs队列中。其他线程需要重新获取锁
            condition.signalAll();
            log.info("send signal"); // 3
            reentrantLock.unlock();
        }).start();
    }
}
