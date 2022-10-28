package com.myooo.myooo.practice.array;

import java.util.Arrays;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * <a href="https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/">...</a>
 * //    [
 * //            [1,   4,  7, 11, 15],
 * //            [2,   5,  8, 12, 19],
 * //            [3,   6,  9, 16, 22],
 * //            [10, 13, 14, 17, 24],
 * //            [18, 21, 23, 26, 30]
 * //    ]
 */

public class SpiralOrder {


    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        int[][] matrix = new int[][]{{1, 2, 3, 4, 5}, {16, 17, 18, 19, 6}, {15, 24, 25, 20, 7}, {14, 23, 22, 21, 8},{13, 12, 11, 10, 9}};
        System.out.println(Arrays.toString(spiralOrder(matrix)));
        System.out.println(Arrays.toString(spiral(matrix)));
    }


    public static int[] spiral(int[][] matrix) {

        if (matrix.length == 0) {
            return new int[0];
        }

        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] result = new int[rows * columns];
        //坐标
        int top = 0, right = columns - 1, left = 0, bottom = rows - 1, index = 0;
        while (top <= bottom && left <= right) {
            for (int column = left; column <= right; column++) {
                result[index++] = matrix[top][column];
            }
            for (int row = top + 1; row <= bottom; row++) {
                result[index++] = matrix[row][right];
            }

            if (top < bottom && left < right) {
                for (int column = right - 1; column > left;column--) {
                    result[index++] = matrix[bottom][column];
                }
                for (int row = bottom; row > top; row --) {
                    result[index++] = matrix[row][left];
                }
            }
            top++;
            right--;
            bottom--;
            left++;
        }
        return result;
    }



    /**
     *  对于每层，从左上方开始以顺时针的顺序遍历所有元素。假设当前层的左上角位于 (top,left)，右下角位于 (bottom,right)，按照如下顺序遍历当前层的元素。
     *
     *     从左到右遍历上侧元素，依次为 (top,left) 到 (top,right)。
     *
     *     从上到下遍历右侧元素，依次为 (top+1,right) 到 (bottom,right)。
     *
     *     如果 left<right 且 top<bottom，则从右到左遍历下侧元素，依次为 (bottom,right−1) 到 (bottom,left+1)，以及从下到上遍历左侧元素，依次为 (bottom,left) 到 (top+1,left)。
     *
     *     遍历完当前层的元素之后，将 left 和 top 分别增加 1，将 right 和bottom 分别减少 1，进入下一层继续遍历，直到遍历完所有元素为止。
     *
     *     <a href="https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/solution/shun-shi-zhen-da-yin-ju-zhen-by-leetcode-solution/">...</a>
     */

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[] order = new int[rows * columns];
        int index = 0;
        //索引
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order[index++] = matrix[top][column];
            }
            for (int row = top + 1; row <= bottom; row++) {
                order[index++] = matrix[row][right];
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order[index++] = matrix[bottom][column];
                }
                for (int row = bottom; row > top; row--) {
                    order[index++] = matrix[row][left];
                }
            }
            //边界缩减
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }

}
