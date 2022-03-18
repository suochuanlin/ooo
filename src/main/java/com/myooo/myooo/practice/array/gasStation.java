package com.myooo.myooo.practice.array;

/**
 * https://leetcode-cn.com/problems/gas-station/solution/jia-you-zhan-by-leetcode/
 * // todo 下面写的不对
 */
public class gasStation {
    public static void main(String[] args) {
        int[] gas  = new int[]{1,2,3,4,5};
        int[] cost  = new int[]{3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));

    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n - 1; i++) {
            boolean canComplete = true;
            boolean jump = false;
            while (true) {
                for (int j = i; j < i + n - 1; j++) {
                    int i1 = j > (n - 1) ? j - (n - 1) : j;
//                    if (gas[i1] - cost[i1] < gas[(i1) + 1]) {
                    if (gas[i1] - cost[i1] + gas[i + 1] < cost[i + 1]) {
                        canComplete = false;
                        break;
                    }
                }
                if (!canComplete) {
                    break;
                } else {
                    jump = true;
                    break;
                }
            }
            if (jump) {
                return i;
            }

        }
        return -1;
    }
}
