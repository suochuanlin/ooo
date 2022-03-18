package com.myooo.myooo.practice.array;

public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = new int[]{1,2};
        int i = maxProfit(prices);
        System.out.println(i);
    }

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
}
