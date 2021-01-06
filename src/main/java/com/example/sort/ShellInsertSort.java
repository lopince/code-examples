package com.example.sort;

import com.example.util.JsonUtils;
import com.example.util.NumsGenerator;

public class ShellInsertSort {

    public static void sort(int[] nums, int totalSteps) {
        for (int step = totalSteps; step > 0; step--) {
            shellSort(nums, step);
            System.out.println(String.format("step: %d, sorted result: %s",
                    step,
                    JsonUtils.toJsonString(nums)));
        }
    }

    private static void shellSort(int[] nums, int currentStep) {

        for (int i = currentStep; i < nums.length; i += currentStep) {
            int sentry = nums[i];

            // 寻找当前节点合适的插入位置
            int j = i;

            // 循环，找到第一个小于当前节点的位置
            for (; j > 0 && nums[j - currentStep] > sentry; j -= currentStep) {
                nums[j] = nums[j - currentStep];
            }

            nums[j] = sentry;
        }
    }

    public static void main(String[] args) {
        int[] nums = NumsGenerator.generate(20);
        System.out.println(JsonUtils.toJsonString(nums));

        sort(nums, 5);

        System.out.println(JsonUtils.toJsonString(nums));
    }

}
