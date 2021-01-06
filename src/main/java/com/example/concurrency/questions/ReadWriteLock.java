package com.example.concurrency.questions;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 基于互斥锁实现读写锁，写优先
 */
public class ReadWriteLock {

    private volatile int reader_cnt = 0;
    private volatile int writer_cnt = 0;

    private final ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void readLock() {

        lock.lock();

        try {
            // 循环等待写锁释放
            while (writer_cnt > 0) {
                try {
                    // 使当前线程绑定了condition对象
                    // 同时进入等待队列，等待被其他线程通知
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            reader_cnt++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void readUnlock() {

        lock.lock();
        try {
            reader_cnt--;

            // 通知绑定了condition对象的其他线程
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void writeLock() {
        lock.lock();
        try {
            // 获取写锁，必须同时释放读锁和写锁
            while (writer_cnt > 0 || reader_cnt > 0) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            writer_cnt++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void writeUnlock() {
        lock.lock();
        try {
            writer_cnt--;
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private final static ReadWriteLock read_write_lock = new ReadWriteLock();

    private static class Reader extends Thread {

        private int i = 0;

        public Reader(int i) {
            super();
            this.i = i;
        }

        @Override
        public void run() {
            while (true) {
                // lock.readLock().lock();
                read_write_lock.readLock();
                System.out.println("i am reading" + " " + i);
                // lock.readLock().unlock();
                read_write_lock.readUnlock();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static class Writer extends Thread {

        @Override
        public void run() {
            while (true) {
                // lock.writeLock().lock();
                read_write_lock.writeLock();
                System.out.println("i am writing");
                // lock.writeLock().unlock();
                read_write_lock.writeUnlock();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread reader1 = new Reader(1);
        Thread reader2 = new Reader(2);
        Thread writer = new Writer();
        reader1.join();
        reader2.join();
        writer.join();

        reader1.start();
        reader2.start();
        writer.start();
    }

}
