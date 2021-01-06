package com.example.util;

import java.util.Random;

public class NumsGenerator {

    public static int[] generate(int size) {

        return generate(size, 100);
    }

    public static int[] generate(int size, int bound) {

        int[] nums = new int[size];

        while (size-- > 0) {
            nums[size] = new Random().nextInt(bound) + 1;
        }

        return nums;
    }
}
