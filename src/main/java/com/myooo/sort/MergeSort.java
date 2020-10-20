package com.myooo.sort;

import java.util.Arrays;

/**
 * 归并排序
 * B站up主 正月点灯笼
 * https://www.bilibili.com/video/BV1Ax411U7Xx?from=search&seid=13451427875077069270
 */
public class MergeSort {


    public static void main(String[] args) {
        int[] arr = new int[]{2, 8, 9, 10, 4, 5, 6, 7};
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(String.valueOf(arr[i]));
        }

    }

    //分治

    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) return;
        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        //m 为啥是m + 1
        mergeSort(arr, m + 1, r);
        merge(arr, l, m + 1, r);
    }

      /**
     *
     * @param arr 排序数组
     * @param l  左边坐标
     * @param m  中间左边
     * @param r  右边坐标
     */
//  合并
    public static void merge(int[] arr, int l, int m, int r) {
        int leftSize = m - l;
        int rightSize = r - m + 1;
        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];

        //1、build left 填满左边数组
        for (int i = l; i < m; i++) {
            leftArr[i - l] = arr[i];
        }
        //2、build right 填满右边数组
        for (int i = m; i <= r; i++) {
            rightArr[i - m] = arr[i];
        }
        //3、merge original arr
        int i = 0;
        int j = 0;
        int k = l; //合并好的数组开始坐标
        while (i < leftSize && j < rightSize) {
            if (leftArr[i] < rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
                k++;
            } else {
                arr[k] = rightArr[j];
                j++;
                k++;
            }
        }



        while (i < leftSize) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }


        while (j < rightSize) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }

    }

}
