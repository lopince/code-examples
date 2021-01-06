package com.example.sort;

import com.example.util.JsonUtils;
import com.example.util.NumsGenerator;

/**
 * 直接插入
 * <p>
 * 将一个记录插入到已排好序的有序表中
 */
public class InsertSort {

    //
    public static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int sentry = nums[i];

            // 寻找当前节点合适的插入位置
            int j = i;

            // 循环，找到第一个小于当前节点的位置
            for (; j > 0 && nums[j - 1] > sentry; j--) {
                nums[j] = nums[j - 1];
            }

            nums[j] = sentry;
        }
    }

    public static void main(String[] args) {

        int[] nums = NumsGenerator.generate(20);
        System.out.println(JsonUtils.toJsonString(nums));

        sort(nums);

        System.out.println(JsonUtils.toJsonString(nums));
    }
}
