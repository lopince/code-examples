package com.example.concurrency.questions;

/**
 * 基于互斥锁实现读写锁，写优先
 */
public class ReadWriteLock {

    private volatile int read_cnt = 0;
    private volatile int write_cnt = 0;

    public void readLock() throws InterruptedException {

        while (write_cnt > 0) {
            synchronized (this) {
                wait();
            }
        }

        read_cnt++;

        System.out.println("获取读锁：" + Thread.currentThread().getId());
    }

    public void readUnLock() {

        read_cnt--;
        synchronized (this) {
            notifyAll();
        }

        System.out.println("释放读锁：" + Thread.currentThread().getId());
    }

    public void writeLock() throws InterruptedException {

        while (write_cnt > 0) {
            synchronized (this) {
                wait();
            }
        }

        write_cnt++;

        while (read_cnt > 0) {
            synchronized (this) {
                wait();
            }
        }

        System.out.println("获取写锁：" + Thread.currentThread().getId());
    }

    public void writeUnLock(){
        write_cnt--;
        synchronized (this){
            notifyAll();
        }
    }
}
