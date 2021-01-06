package com.example.sort;

import com.example.util.JsonUtils;
import com.example.util.NumsGenerator;

public class HeapSort {

    public static void main(String[] args) {
        int[] nums = NumsGenerator.generate(20);
        System.out.println(JsonUtils.toJsonString(nums));

        sort(nums);

        System.out.println(JsonUtils.toJsonString(nums));
    }

    private static void sort(int[] nums) {

        // 创建堆
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            System.out.println("i: " + i);
            adjustHeap(nums, i, nums.length);
        }


        for (int i = nums.length - 1; i > 0; i--) {

            // 堆顶元素与末尾元素交换
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;

            // 继续调整剩余元素
            adjustHeap(nums, 0, i);

            // 每次调整后，堆为大顶堆，即数组第一个元素为最大元素
            System.out.println(String.format("heap range[%d, %d]: %s",
                    0,
                    i,
                    JsonUtils.toJsonString(nums)));
        }
    }

    private static void adjustHeap(int[] nums, int parent, int length) {

        // 堆为完全二叉树，因此可以用一个数组表示

        // 数组下标从0开始，正常左孩子是parent*2
        //              ()   parent
        //             /  \
        // 2*parent+1 ()  () 2*parent+2

        // 堆顶节点
        int headRoot = nums[parent];

        // 选取父节点的左孩子为候选堆顶
        int child = 2 * parent + 1;

        while (child < length) {

            int rChild = child + 1;

            // 右孩子存在
            if (rChild < length

                    // 左孩子小于右孩子
                    && nums[child] < nums[rChild]) {
                child++;
            }

            // 判断当前子堆是否已经已调整完成
            if (headRoot >= nums[child]) {
                break;
            }
            nums[parent] = nums[child];

            // 继续调整余下子堆
            parent = child;
            child = 2 * child + 1;
        }
        nums[parent] = headRoot;
    }
}
