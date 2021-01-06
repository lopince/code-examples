package com.example.concurrency.singleton;

public class LazySingleton {

    private static volatile LazySingleton instance;

    private LazySingleton(){

    }

    public static LazySingleton getInstance() {

        //第一层检查，检查是否有引用指向对象
        if (instance == null) {

            //第一层锁，保证只有一个线程进入
            synchronized (LazySingleton.class) {

                // 双重检查，防止多个线程同时进入第一层检查，进而产生多个对象指向引用
                if (instance == null) {

                    // volatile 关键字作用为禁止指令重排，保证返回Singleton对象一定在创建对象后
                    instance = new LazySingleton();
                }
            }
        }

        return instance;
    }
}
