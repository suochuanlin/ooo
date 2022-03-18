package com.myooo.myooo.practice.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *      复原IP地址
 *
        有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
        例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
        给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入'.' 来形成。
        你不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。


        示例 1：
        输入：s = "25525511135"
        输出：["255.255.11.135","255.255.111.35"]

        示例 2：
        输入：s = "0000"
        输出：["0.0.0.0"]

        示例 3：
        输入：s = "1111"
        输出：["1.1.1.1"]

        示例 4：
        输入：s = "010010"
        输出：["0.10.0.10","0.100.1.0"]

        示例 5：
        输入：s = "101023"
        输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]

        提示：
        0 <= s.length <= 20
        s 仅由数字组成
        通过次数165,008
        提交次数303,390

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/restore-ip-addresses
             https://leetcode-cn.com/problems/restore-ip-addresses/solution/hui-su-suan-fa-hua-tu-fen-xi-jian-zhi-tiao-jian-by/
 **/
public class RestoreIPAddress {

    //方法一
    public List<String> method1RestoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len > 12 || len < 4) {
            return res;
        }

        Deque<String> path = new ArrayDeque<>(4);
        dfs(s, len, 0, 4, path, res);
        return res;
    }

    // 需要一个变量记录剩余多少段还没被分割
    private void dfs(String s, int len, int begin, int residue, Deque<String> path, List<String> res) {
        if (begin == len) {
            if (residue == 0) {
                res.add(String.join(".", path));
            }
            return;
        }

        for (int i = begin; i < begin + 3; i++) {
            if (i >= len) {
                break;
            }

            if (residue * 3 < len - i) {
                continue;
            }

            if (judgeIpSegment(s, begin, i)) {
                String currentIpSegment = s.substring(begin, i + 1);
                path.addLast(currentIpSegment);

                dfs(s, len, i + 1, residue - 1, path, res);
                path.removeLast();
            }
        }
    }

    private boolean judgeIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }

        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }

        return res >= 0 && res <= 255;
    }


    /**
     * 方法二
     *     方法一：回溯
     *             思路与算法
     *
     *     由于我们需要找出所有可能复原出的 IP 地址，因此可以考虑使用回溯的方法，对所有可能的字符串分隔方式进行搜索，并筛选出满足要求的作为答案。
     *
     *     设题目中给出的字符串为 ss。我们用递归函数 \textit{dfs}(\textit{segId}, \textit{segStart})dfs(segId,segStart) 表示我们正在从 s[\textit{segStart}]s[segStart] 的位置开始，搜索 IP 地址中的第 \textit{segId}segId 段，其中 \textit{segId} \in \{0, 1, 2, 3\}segId∈{0,1,2,3}。由于 IP 地址的每一段必须是 [0, 255][0,255] 中的整数，因此我们从 \textit{segStart}segStart 开始，从小到大依次枚举当前这一段 IP 地址的结束位置 \textit{segEnd}segEnd。如果满足要求，就递归地进行下一段搜索，调用递归函数 \textit{dfs}(\textit{segId} + 1, \textit{segEnd} + 1)dfs(segId+1,segEnd+1)。
     *
     *     特别地，由于 IP 地址的每一段不能有前导零，因此如果 s[\textit{segStart}]s[segStart] 等于字符 00，那么 IP 地址的第 \textit{segId}segId 段只能为 00，需要作为特殊情况进行考虑。
     *
     *     在搜索的过程中，如果我们已经得到了全部的 44 段 IP 地址（即 \textit{segId} = 4segId=4），并且遍历完了整个字符串（即 \textit{segStart} = |s|segStart=∣s∣，其中 |s|∣s∣ 表示字符串 ss 的长度），那么就复原出了一种满足题目要求的 IP 地址，我们将其加入答案。在其它的时刻，如果提前遍历完了整个字符串，那么我们需要结束搜索，回溯到上一步。
     *
     *     代码
     *
     *     作者：LeetCode-Solution
     *     链接：https://leetcode-cn.com/problems/restore-ip-addresses/solution/fu-yuan-ipdi-zhi-by-leetcode-solution/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<>();
    int[] segments = new int[SEG_COUNT];

    public List<String> method2RestoreIpAddresses(String s) {
        segments = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return ans;
    }

    public void dfs(String s, int segId, int segStart) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }

        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 255) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        String s = "25525511135";
        RestoreIPAddress restoreIPAddress = new RestoreIPAddress();
        System.out.println(restoreIPAddress.method2RestoreIpAddresses(s));
    }
}
