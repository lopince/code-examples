package com.example.util;

import java.util.Random;

public class LangUtils {

    public static void newThreadThenStart(Runnable runnable) {

        new Thread(runnable).start();
    }

    public static void loop(int repeat, Runnable runnable) {

        for (int i = 0; i < repeat; i++) {
            runnable.run();
        }
    }

    public static void sleepRandom(int bound) {

        int randomInt = new Random().nextInt(bound) + 1;
        sleep(randomInt * 1000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
