package com.myooo.myooo.practice.characterString;

//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
//        注意：
//        num1 和num2 的长度都小于 5100.
//        num1 和num2 都只包含数字 0-9.
//        num1 和num2 都不包含任何前导零。
//        你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。

public class addString {
    public static void main(String[] args) {
//        String num1 = "654321";
//        for (int i = 0; i < num1.length(); i++) {
//            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
//            i++;
//            System.out.println(n1);
//        }
        System.out.println(addStrings("999", "99"));
    }

    public static String addTwoString(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int minLength = Math.min(m, n);
        int maxLength = Math.max(m, n);
        String maxText = m >= n ? text1 : text2;
        String minText = m >= n ? text2 : text1;
        int temp = 0;
        StringBuilder sum = new StringBuilder();
        for (int i = 1; i <= maxLength; i++) {
            char maxeach = maxText.charAt(maxLength - i); // 长的
            char mineach = i <= minLength ? minText.charAt(minLength - i): '0';
            int sumeach = (maxeach - '0') + (mineach - '0') + temp;
            temp = sumeach >= 10 ? 1 : 0;
            sum.append(sumeach % 10);
        }
        if (temp == 1) {
            sum.append("1");
        }
        return sum.reverse().toString(); //反转

    }

    public static String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--;
            j--;
        }
        if (carry == 1) res.append(1);
        return res.reverse().toString();
    }

}
