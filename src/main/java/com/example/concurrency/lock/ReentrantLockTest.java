package com.example.concurrency.lock;

import java.util.concurrent.locks.LockSupport;

public class ReentrantLockTest {

    public static void main(String[] args) throws Exception {

        Task task1 = new Task(1);
        Task task2 = new Task(2);

        task1.setOther(task2);
        task2.setOther(task1);

        task1.start();
        task2.start();
    }

    private static class Task extends Thread{

        Task other;
        int start;

        Task(int start){
            this.start = start;
        }

        public void setOther(Task other) {
            this.other = other;
        }

        @Override
        public void run() {
            for (int i = start; i < 10; i += 2) {
                System.out.println(i);
                LockSupport.park(this);
                LockSupport.unpark(other);
            }
        }
    }
}
