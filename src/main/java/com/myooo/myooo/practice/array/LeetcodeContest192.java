package com.myooo.myooo.practice.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LeetcodeContest192 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        System.out.print(getStrongest(nums,2));
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];
        int[] x = new int[n];
        int[] y = new int[n];
        int used = 0;
        for (int i = 0; i < 2*n; i++) {
            if (i < n) x[i] = nums[i];
            if (i >= n) y[i - n] = nums[i];
        }
        for (int i = 0; i < n; i++) {
           res[used] = x[i];
           used++;
           res[used] = y[i];
           used++;
        }
        return res;

    }

    public static int[] getStrongest2(int[] arr, int k) {
        Arrays.sort(arr);

//        Arrays.sort(IntStream.of(arr).boxed().collect(Collectors.toList()).toArray(new Integer[0]),cmp);
        //中位数
        int m = arr[((arr.length - 1) / 2)];
        int[] res = new int[k];
        for (int i = 0; i < arr.length - 1; i++) {//外层循环控制排序趟数
            for (int j = 0; j < arr.length - 1 - i; j++) {//内层循环控制每一趟排序多少次
                if (Math.abs(arr[j] -m) > Math.abs(arr[j + 1] -m) ||
                        (Math.abs(arr[j] -m) > Math.abs(arr[j + 1] -m) && arr[j] > arr[j + 1])
                ) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        int n = arr.length;
        for (int i = 0; i < k; i++) {
            res[i] = arr[n -1 - i];
        }
        return res;
    }

    public static int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        //中位数
        int m = arr[((arr.length - 1) / 2)];
        Comparator<Integer> cmp = new MyComparator(m);
        Integer[] arrBox = IntStream.of(arr).boxed().collect(Collectors.toList()).toArray(new Integer[0]);
        Arrays.sort(arrBox,cmp);
        int[] res = new int[k];
        int n = arrBox.length;
        for (int i = 0; i < k; i++) {
            res[i] = arrBox[n -1 - i];
        }
        return res;
    }

    static class MyComparator implements Comparator<Integer> {
        private int m;

        public MyComparator(int m) {
            this.m = m;
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            boolean flag = Math.abs(o1 - m) > Math.abs(o2 - m) ||
                    ((Math.abs(o1 - m) == Math.abs(o2 - m) && o1 > o2));
            return flag ? 1 : -1;
        }
    }
}
