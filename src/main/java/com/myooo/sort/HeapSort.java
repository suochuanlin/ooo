package com.myooo.sort;

import java.util.Arrays;

/**
 * 选择排序（Selection sort）是一种简单直观的排序算法。它的工作原理是：第一次从待排序的数据元素中选出最小（或最大）的一个元素，
 * 存放在序列的起始位置，然后再从剩余的未排序元素中寻找到最小（大）元素，然后放到已排序的序列的末尾。
 * 以此类推，直到全部待排序的数据元素的个数为零。选择排序是不稳定的排序方法。
 *
 * 选择排序优化后为堆排序
 *
 * 参考资料
 * https://www.cnblogs.com/chengxiao/p/6129630.html
 * https://www.cnblogs.com/lanhaicode/p/10546257.html
 */

public class HeapSort {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 3, 1, 10, 7};
        heapSort(nums);
    }

    public static void heapSort(int[] nums) {
        //1、原地建堆 heapify
        buildHeap(nums);
        //2、然后进行堆排序 siftDown/siftUp (交换并拿出最后一个节点)
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, i, 0);
            heapify(nums, i, 0);
        }
        //3、打印
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void buildHeap(int[] nums) {
        int heapSize = nums.length;
        int lastNotLeafIdx = (heapSize - 1) / 2;
        for (int i = lastNotLeafIdx; i >= 0; i--) {
            heapify(nums, heapSize, i);
        }
    }

    /**
     *
     * @param array 数组
     * @param n 数组长度
     * @param pIdx 当前操作的下标
     */
    public static void heapify(int[] array, int n, int pIdx) {
        if (pIdx >= n ) return;
        int lIdx = 2 * pIdx + 1; //左节点
        int rIdx = 2 * pIdx + 2; //右节点
        int max = pIdx;
        if (lIdx < n && array[lIdx] > array[max]) {
            max = lIdx;
        }
        if (rIdx < n && array[rIdx] > array[max]) {
            max = rIdx;
        }
        if (max != pIdx) {
            swap(array, max, pIdx);
            heapify(array, n, max);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
