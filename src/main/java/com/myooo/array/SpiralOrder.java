package com.myooo.array;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
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
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        SpiralOrder instance = new SpiralOrder();
        instance.spiralOrder(matrix);
    }

    public int[] spiralOrder(int[][] matrix) {

        int row = matrix.length; //行数
        int col = matrix[0].length; //列数

        int i = 0; //记录当前行
        int j = 0; //记录当前
        int n = 0;

        int[] result = new int[row * col];

        while (n < row * col) {

            result[n] = matrix[i][j];
            n++;
        }
        return result;

    }
}
