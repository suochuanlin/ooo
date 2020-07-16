package com.myooo.leetcode;

import java.util.Stack;

public class TernaryExpressionParser {
    /**

    [LeetCode] Ternary Expression Parser 三元表达式解析器

    Given a string representing arbitrarily nested ternary expressions, calculate the result of the expression.
     You can always assume that the given expression is valid and only consists of digits 0-9, ?, :, T and F (T and Frepresent True and False respectively).
    Note:
    The length of the given string is ≤ 10000.
    Each number will contain only one digit.
    The conditional expressions group right-to-left (as usual in most languages).
    The condition will always be either T or F. That is, the condition will never be a digit.
    The result of the expression will always evaluate to either a digit 0-9, T or F.

     给定一个表示任意嵌套的三元表达式的字符串，计算表达式的结果。
     您总是可以假定给定的表达式是有效的，并且只由数字0-9组成？，：，T和F（T和fre分别表示真和假）。
     注：
     给定字符串的长度≤10000。
     每个数字只包含一个数字。
     条件表达式从右向左分组（与大多数语言中一样）。
     条件永远是T或F。也就是说，条件永远不会是数字。
     表达式的结果将始终计算为数字0-9、T或F。

     Example 1:
    Input: "T?2:3"
    Output: "2"
    Explanation: If true, then result is 2; otherwise result is 3.

    Example 2:
    Input: "F?1:T?4:5"
    Output: "4"
    Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:

            "(F ? 1 : (T ? 4 : 5))"                   "(F ? 1 : (T ? 4 : 5))"
            -> "(F ? 1 : 4)"                 or       -> "(T ? 4 : 5)"
            -> "4"                                    -> "4"

    Example 3:
    Input: "T?T?F:5:3"
    Output: "F"
    Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:

            "(T ? (T ? F : 5) : 3)"                   "(T ? (T ? F : 5) : 3)"
            -> "(T ? F : 3)"                 or       -> "(T ? F : 5)"
            -> "F"                                    -> "F"
     *
     */
    public static void main(String[] args) {
        String ex = "T?T?F:5:3";
        System.out.println(expressTer(ex));
    }

    public static String expressTer(String expression) {

        if (expression == null) {
            throw new RuntimeException("字符为空");
        }
        char[] array = expression.toCharArray();
        Stack<Character> s = new Stack<>();
        for (int i = array.length; i > 0; i--) {
            if (!s.isEmpty() && s.peek() == '?') {
                s.pop(); // 弹出 '？'
                char first = s.pop();
                s.pop(); //弹出 '：'
                char second = s.pop();
                char c = array[i - 1] == 'T' ? first : second;
                s.push(c);
            } else {
                s.push(array[i - 1]);
            }

        }
        return s.peek().toString();
    }



}
