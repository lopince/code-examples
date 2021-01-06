package com.example.sort;

import com.example.util.JsonUtils;
import com.example.util.NumsGenerator;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = NumsGenerator.generate(20);
        System.out.println(JsonUtils.toJsonString(nums));

        sort(nums);

        System.out.println(JsonUtils.toJsonString(nums));
    }

    public static void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private static void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    private static void merge(int[] nums, int low, int mid, int high) {

        System.out.println(String.format("low: %d, high: %d, step: %d",
                low,
                high,
                (high - low) + 1));

        // 借助一个辅助数组
        int[] mergedNums = Arrays.copyOf(nums, nums.length);

        // 将有序的 nums[i..m] 和 nums[m+1, n] 归并为有序的 nums[i..n]
        int j = mid + 1;
        int index = low;
        for (; low <= mid && j <= high; ) {
            if (nums[low] < nums[j]) {
                mergedNums[index++] = nums[low++];
            } else {
                mergedNums[index++] = nums[j++];
            }
        }

        while (low <= mid) {
            mergedNums[index++] = nums[low++];
        }
        while (j <= high) {
            mergedNums[index++] = nums[j++];
        }

        System.out.println(String.format("merged nums: %s",
                JsonUtils.toJsonString(mergedNums)));
        System.out.println();

        System.arraycopy(mergedNums, 0, nums, 0, nums.length);
    }
}
