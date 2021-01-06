package com.example.sort;

import com.example.util.NumsGenerator;

import java.util.Arrays;

public class MergeSortTemplate {

    public static void main(String[] args) {

        int[] nums = NumsGenerator.generate(20);
        System.out.println("Sorting: " + Arrays.toString(nums));

        mergeSort(nums);
        System.out.println("Sorted: " + Arrays.toString(nums));
    }

    private static void mergeSort(int[] nums) {
    }

    private static void mergeSort(int[] nums, int low, int high) {

    }

    private static void merge(int[] nums, int low, int mid, int high) {

    }

}
