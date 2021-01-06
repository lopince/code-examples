package com.example.sort;

import com.example.util.NumsGenerator;

import java.util.Arrays;

public class HeapSortTemplate {

    public static void main(String[] args) {

        int[] nums = NumsGenerator.generate(20);
        System.out.println("Sorting: " + Arrays.toString(nums));

        heapSort(nums);
        System.out.println("Sorted: " + Arrays.toString(nums));
    }

    private static void heapSort(int[] nums) {

    }

    private static void adjustHeap(int[] nums, int parent, int length) {

        int heapRoot = nums[parent];

        int child = 2 * parent + 1;
        while (child < length) {

            int rChild = child + 1;

            // 选择孩子中，较大者
            if (rChild < length && nums[child] < nums[rChild]) {
                child++;
            }

            if (heapRoot >= nums[child]) {
                break;
            }

            nums[parent] = nums[child];
            parent = child;
            child = 2 * child + 1;
        }

        nums[parent] = heapRoot;
    }
}
