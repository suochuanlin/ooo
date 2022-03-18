package com.myooo.myooo.practice.array;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 */
public class FindNumberIn2DArray {
//    [
//            [1,   4,  7, 11, 15],
//            [2,   5,  8, 12, 19],
//            [3,   6,  9, 16, 22],
//            [10, 13, 14, 17, 24],
//            [18, 21, 23, 26, 30]
//    ]
//
//    target = 5;

    public static void main(String[] args) {
        FindNumberIn2DArray instance = new FindNumberIn2DArray();
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};

        int[][] matrix1 = new int[][]{{-5}};
        System.out.println(instance.findNumberIn2DArray(matrix1,-5));
    }
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        System.out.println("matrix lenth = " + matrix.length);
        if (matrix.length == 0) {
            return false;
        }
        int r = matrix.length; //行数
        int col = matrix[0].length; //列数
        int i = 0; //第0行开始
        int j = col - 1; //最后一列开始
        while (i < r && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (target > matrix[i][j]) {
                i++;
            } else if (target < matrix[i][j]) {
                j--;
            }
        }
        return false;
    }
}
