package com.pickbucket.leetcode.easy;

import java.util.Scanner;
import java.util.Stack;

public class P_20_isValid {
    public static boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return false;
        }
        boolean ans = false;
        Stack<Character> stack = new Stack<>();
        stack.push('#');
        for(int i = 0; i < s.length(); i++){
            if((s.charAt(i) == ')' && stack.peek() == '(') || (s.charAt(i) == ']' && stack.peek() == '[') ||
                    (s.charAt(i) == '}' && stack.peek() == '{')){
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        if(stack.peek() == '#') {
            ans = true;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isValid(s));
    }
}
