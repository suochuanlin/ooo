package com.myooo.myooo.practice.array;

//lc 39. 数组中出现次数超过一半的数字
//        数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
//        你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//剑指offer 39
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
// 输出: 2
/**
 * 本题常见解法如下：
 *
 *         哈希表统计法： 遍历数组 nums ，用 HashMap 统计各数字的数量，最终超过数组长度一半的数字则为众数。此方法时间和空间复杂度均为 O(N)O(N) 。
 *         数组排序法： 将数组 nums 排序，由于众数的数量超过数组长度一半，因此 数组中点的元素 一定为众数。此方法时间复杂度 O(N log_2 N)O(Nlog2N)。
 *         摩尔投票法： 核心理念为 “正负抵消” ；时间和空间复杂度分别为 O(N)O(N) 和 O(1)O(1) ；是本题的最佳解法。
 *
 *         作者：jyd
 *         链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/
 *         来源：力扣（LeetCode）
 *         著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
//摩尔投票法：
//        票数和： 由于众数出现的次数超过数组长度的一半；若记 众数 的票数为 +1 ，
//        非众数 的票数为 -1 ，则一定有所有数字的 票数和 >0 。
//        票数正负抵消： 设数组 nums 中的众数为 x ，数组长度为 n 。
//        若 nums 的前 a 个数字的 票数和 =0 ，则 数组后 (n−a) 个数字的 票数和一定仍 >0,
//        （即后 (n-a)个数字的 众数仍为 x ）。


public class majorityElement {
//    public int majorityElement(int[] array) {
//        return -1;
//    }

    /**
     * 摩尔投票法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}
