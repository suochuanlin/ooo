package com.myooo.myooo.practice.array;
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
//        说明：
//        你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//        示例 1:
//        输入: [2,2,1]
//        输出: 1

import java.util.HashMap;
import java.util.Map;

//        示例 2:
//        输入: [4,1,2,1,2]
//        输出: 4
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/single-number
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//        关于 |= 运算符：|= 运算符和 += 这一类的运算符一样，拆解开就是 a = a | b；
//      具体规则为：两个二进制对应位为0时该位为0，否则为1。拿5的二进制 0000 0101 和 3的二进制 0000 0011 进行|运算，后三位的的对应位都不是同时等于0，所以最终结果为 0000 0111 也就是7的二进制。
public class singleNumber {

    public int searchSingleNumber(int[] array) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int n = 1;
            if (map.containsKey(array[i])) n++;
            map.put(array[i], n);
        }
        for (int i = 0; i < array.length; i++) {
            int count = map.get(array[i]);
            if (count == 1) {
                return array[i];
            }
        }
        throw new RuntimeException("无符合条件数字");
    }

    // ^= (异或) 两个二进制对应位相同时，结果为0，否则结果为1
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int num: nums) {
            ans ^= num;
        }
        return ans;
    }
}
