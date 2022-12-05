package com.myooo.myooo.practice.array;

/**
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MaxProfit {


    public static void main(String[] args) {
        int[] prices = new int[]{1,2};
        int i = maxProfit(prices);
        System.out.println(i);
    }

    /**
     * 解法一、暴力解法
     * @param prices 价格数组
     * @return
     */
    public static int maxProfit(int[] prices) {

        int length = prices.length;
        int result = 0;
        for (int i = length - 1; i > 0; i--) {
            int price = prices[i];//基础数值
            for (int j = i - 1; j >= 0; j--) {
                if (price - prices[j] > result) {
                    result = price - prices[j];
                }
            }
        }
        return result;
    }

    /**
     * DP 动态规划解法
     */



}
