package com.myooo.myooo.practice.recursion;

/**
 * 二分查找（二分搜索）
 * Binary Search
 * 有序数组 寻找key下标
 */
public class BinarySearch {


    public static void main(String[] args) {
        int[] array = new int[]{0,1,2,3,4,5,6,7,8,9};
        int key = 5;
        rank(key, array);
    }
    public static void rank(int key, int[] array) {
        System.out.println(rank(key, 0, array.length -1 , array));
    }

    public static int rank(int key, int startIdx, int endIdx, int[] arr) {
//        编写递归时最重要的三个步骤:
        //1、递归总有一个最简单的情况----方法的第一条语句总是包含return的条件语句。
        if (startIdx > endIdx) {
            return -1;
        }
        //2、递归调用总是去尝试解决一个规模更小的子问题，这样递归才能收敛到最简单的情况。在下面代码中，入参数坐标一直在缩小。
        int mid = (startIdx + endIdx) / 2;
        //3、递归调用的父问题和尝试解决的子问题之间不应该有交集。在下面的代码中，两个子问题操作的数组部分时不同的。
        if (key > arr[mid]) {
            return rank(key, mid, endIdx, arr);
        } else if (key < arr[mid]) {
            return rank(key, startIdx, mid, arr);
        } else {
            return mid;
        }
    }
}
