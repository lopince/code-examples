package com.example.sort;

import com.example.util.NumsGenerator;

import java.util.Arrays;
import java.util.Stack;

public class QuickSortTemplate {

    public static void main(String[] args) {

        int[] nums = NumsGenerator.generate(20);
        System.out.println("Sorting: " + Arrays.toString(nums));

        quickSort(nums);
        System.out.println("Sorted: " + Arrays.toString(nums));
    }

    private static void quickSort(int[] nums) {
    }

    private static void quickSort(int[] nums, int low, int high) {

    }

    private static int partition(int[] nums, int low, int high) {

        return 0;
    }
}
