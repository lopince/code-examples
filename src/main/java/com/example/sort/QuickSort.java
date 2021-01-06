package com.example.sort;

import com.example.util.JsonUtils;
import com.example.util.NumsGenerator;

import java.util.Arrays;
import java.util.Stack;

public class QuickSort {

    public static void main(String[] args) {

        int[] nums = NumsGenerator.generate(20);
        System.out.println("Sorting: " + Arrays.toString(nums));

        quickSort(nums);
        System.out.println("Sorted: " + Arrays.toString(nums));
    }

    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            Stack<Integer> stack = new Stack<>();
            stack.push(low);
            stack.push(high);
            while (!stack.isEmpty()) {

                high = stack.pop();
                low = stack.pop();

                int pivotIndex = partition(nums, low, high);

                // 处理前半区
                if (low < pivotIndex - 1) {
                    stack.push(low);
                    stack.push(pivotIndex - 1);
                }

                // 处理后半区
                if (pivotIndex + 1 < high) {
                    stack.push(pivotIndex + 1);
                    stack.push(high);
                }
            }
        }
    }

    private static int partition(int[] nums, int low, int high) {

        // 以nums[low]作为枢轴，交换nums[low...high]中元素，使nums[low]处于正确位置
        int pivot = nums[low];

        while (low < high) {

            // 在高位，找到第一个比pivot小的数，并交换
            while (low < high && nums[high] >= pivot)
                high--;
            nums[low] = nums[high];

            // 在低位，找到第一个比pivot大的数，并交换
            while (low < high && nums[low] <= pivot)
                low++;
            nums[high] = nums[low];
        }

        // 此时，low==high，且low为pivot的正确位置下标
        nums[low] = pivot;

        return low;
    }


}
