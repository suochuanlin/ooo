package com.myooo.myooo.practice.characterString;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
//        String[] arr = new String[]{"flower", "flow", "flight"};
        String[] arr = new String[]{"reflower","flow","flight"};
        String s = longestCommonPrefix(arr);
        System.out.println("sssss:   " + s);
    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String result = strs[0];
        //比较n 和 n+1
        for (int i = 0; i < strs.length - 1; i++) {
            String s2 = strs[i + 1];
            result = compareCommonPrefix(result, s2);
            if (result.length() == 0) {
                break;
            }
        }
        return result;
    }
    private static String compareCommonPrefix(String s1, String s2) {
        int min = Math.min(s1.length(), s2.length());
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int index = 0;
        int tem = 0;
        while (tem < min && chars1[tem] == chars2[tem]) {
            tem++;
            index++;
        }

        return s1.substring(0, index);
    }



}
