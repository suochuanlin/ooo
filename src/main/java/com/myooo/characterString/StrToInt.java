package com.myooo.characterString;

import com.sun.javaws.IconUtil;

public class StrToInt {
//    当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
//    该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
//    注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
//    在任何情况下，若函数不能进行有效的转换时，请返回 0。
//    说明：
//    假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
//    示例 1:
//    输入: "42"
//    输出: 42

//    示例 2:
//    输入: "   -42"
//    输出: -42
//    解释: 第一个非空白字符为 '-', 它是一个负号。
//                 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。

    //    示例 3:
//    输入: "4193 with words"
//    输出: 4193
//    解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof
    public static void main(String[] args) {
        StrToInt o = new StrToInt();
        String a = " -42";
        char[] b = a.trim().toCharArray();
        System.out.println(b);
        //                             214748364
        System.out.println(o.strToInt("2147483646"));
    }
    //这版本有问题 抛弃掉
    public int strToInt(String str) {
        char[] array = str.trim().toCharArray();
        int result = 0, j = 0,sign = 1;
        if ("".equals(str.trim()) || (array[0] != '+' && array[0] != '-' && !Character.isDigit(array[0]))) return result;
        if (array[0] == '+') {
            j = 1;
        }
        if (array[0] == '-') {
            sign = -1;
            j = 1;
        }
        int length = array.length;
        for (int i = j; i < length; i++) {
            char each = array[i];
            if (each > '9' || each < '0') break;;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && array[i] > '7')) {
                return sign ==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (array[i] - '0');
        }
        return sign * result;
    }
}
