package com.pickbucket.leetcode.middle;

import java.util.Stack;

public class reverseSubStr_1190 {
    public static String reverseParentheses(String s) {
        char[] strChars = s.toCharArray();
        Stack<String> stack = new Stack<>();
        StringBuilder str = new StringBuilder();
        for (char ch: strChars) {
            if (ch == '(') {
                // 遇到左括号压str入栈并清空str
                stack.push(str.toString());
                str.setLength(0);
            } else if (ch == ')') {
                // 遇到右括号反转str
                str.reverse();
                // 从栈里弹出外一层字符串，拼接在str头部
                str.insert(0, stack.pop());
            } else {
                // 遇到字符直接拼接在str尾部
                str.append(ch);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String str = reverseParentheses("(u(love)i)");
        System.out.println(str);
    }
}
