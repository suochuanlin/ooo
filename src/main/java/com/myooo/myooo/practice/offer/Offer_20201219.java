package com.myooo.myooo.practice.offer;

/**
 * 专用
 */
public class Offer_20201219 {

    public static void main(String[] args) {
        int[] array = new int[]{3, 1, 2, 0, 2, 5, 3};
        System.out.println(fundRepeatNumber(array));
    }

    //3、0-n-1 的 数组中重复数字 page 40
    public static int fundRepeatNumber(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (array[i] != i) {
                if (array[array[i]] == array[i]) {
                    return array[i];
                }
                //交换
                int temp = array[array[i]];
                array[array[i]] = array[i];
                array[i] = temp;
            }
        }
        throw new RuntimeException("无重复数字");
    }


    //3.1 不修改数组找出重复数字 （长度n+1的数组，所有数字都在1～n的范围内）page 41
    int[] array = new int[]{2, 3, 5, 4, 3, 2, 6, 7};
    public static int fundRepeatNumber_MinSpatialComplexity() {
        return -1;
    }


}
