package com.example.sort;

import com.example.util.JsonUtils;
import com.example.util.NumsGenerator;

public class SelectSort {

    public static void sort(int[] nums) {

        // 每趟，确定第i个位置，是[i, nums.length]的最小元素
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (min > nums[j]) {
                    min = nums[j];
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = NumsGenerator.generate(20);
        System.out.println(JsonUtils.toJsonString(nums));

        sort(nums);

        System.out.println(JsonUtils.toJsonString(nums));
    }
}
