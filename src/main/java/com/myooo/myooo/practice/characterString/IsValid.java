package com.myooo.myooo.practice.characterString;

import java.util.Stack;

public class IsValid {


    public static void main(String[] args) {
        IsValid stance = new IsValid();
        String s = "{[]}";
        System.out.println(stance.isVaild(s));
    }


    public boolean isVaild(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (c != stack.pop()) {
                return false;
            }
        }
        return stack.empty();
    }


}
