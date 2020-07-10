package com.myooo.sort;

/**
 * 计数排序
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] arr = new int[] {10,20,18,12,12};
        int[] newarr = CountingSort01(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(newarr[i]);
        }
    }

    public static int[] CountingSort01(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
        }
        //统计每次整数出现的次数
        int[] countArr = new int[1 + max - min];
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i] - min]++;
        }
        //累加次数
        for (int i = 1; i < countArr.length; i++) {
            countArr[i] += countArr[i - 1];
        }
        //倒序遍历，存入新数组
        int[] newArray = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            //找出arr中每个数字在 countArr中索引 （index = arr[i] - min）
            //自减1，表示前面还有 这些个数字，即代表在新数组的位置
            //重复数字也没问题，因为是循环的 source 数组，重复的也能读到对应的 次数，读出来一次操作一次减1，如此循环
            --countArr[arr[i] - min];
            newArray[countArr[arr[i] - min]] = arr[i];
        }
        return newArray;
    }
    /**
     * 只能排正整数
     * @param arr
     */
    public static void SimpleCountingSort00(int[] arr) {

        //1、循环source arr 计数
        int max = 0;
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            min = Math.min(arr[i],min);
        }
        int[] countArr = new int[1 + max];
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i]]++;
        }
        //2、循环计数的数组排序
        int tmp = 0;
        int index = 0;
        for (int i = 0; i < countArr.length; i++) {
            tmp = countArr[i];
            while (tmp > 0) {
                arr[index] = i;
                index++;
                tmp--;
            }
        }
    }


}
