package com.myooo.myooo.practice.characterString;

import java.util.*;

/**
 *
 * 滑动窗口
 *
 * 无重复字符的最长子串
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class LengthOfLongestSubString {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * 还是这个比较好理解 queue中只维护最新的子串，然后记录queue最长长度
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

        if ("".equals(s) || s == null) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        Queue<Character> queue = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char single : chars) {
            if (queue.contains(single)) {
                while (queue.contains(single)) {
                    queue.poll();
                }
            }
            queue.offer(single);
            set.add(queue.size());
        }
        return set.stream().mapToInt(Integer::new).max().orElse(0);
    }

    public int lengthOfLongestSubstringByMap(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0; //最长长度
        int left = 0;//左指针位置
        for (int i = 0; i < s.length(); i++) {
            /**
             1、首先，判断当前字符是否包含在map中，如果不包含，将该字符添加到map（字符，字符在数组下标）,
             此时没有出现重复的字符，左指针不需要变化。此时不重复子串的长度为：i-left+1，与原来的maxLen比较，取最大值；

             2、如果当前字符包含在map中，此时有2类情况：
             1）当前字符包含在当前有效的子段中，如：abca，当我们遍历到第二个a，当前有效最长子段是 abc，我们又遍历到a，
             那么此时更新 left 为 map.get(a)+1=1，当前有效子段更新为 bca；

             2）当前字符不包含在当前最长有效子段中，如：abba，我们先添加a,b进map，此时left=0，
             我们再添加b，发现map中包含b，而且b包含在最长有效子段中，就是1）的情况，我们更新 left=map.get(b)+1=2，此时最长有效子段更新为 b，
             而且map中仍然包含a，map.get(a)=0；

             随后，我们遍历到a，发现a包含在map中，且map.get(a)=0，如果我们像1）一样处理，就会发现 left=map.get(a)+1=1，实际上，left此时
             应该不变，left始终为2，当前最长有效子段子段变成 ba才对。

             为了处理以上2类情况，我们每次更新left，left=Math.max(left , map.get(ch)+1).
             另外，更新left后，不管原来的 s.charAt(i) 是否在最长子段中，我们都要将 s.charAt(i) 的位置更新为当前的i，
             因此此时新的 s.charAt(i) 已经进入到 当前最长的子段中！
             */
            //map中存在字符串的时候，更新左指针位置
            if (map.containsKey(s.charAt(i))) {
                int leftTemp = map.get(s.charAt(i)) + 1;
                left = Math.max(left, leftTemp);
            }
            //map中不存在重复字符的时候put
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }


}
