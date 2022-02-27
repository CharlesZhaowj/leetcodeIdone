package com.pickbucket.leetcode.medium;

import java.util.*;

public class P_17_letterCombinations {
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        Stack<StringBuffer> temp = new Stack<>();
        Stack<StringBuffer> temp2 = new Stack<>();
        if(digits == null || digits.length() == 0) {
            return ans;
        }

        String[] numbersChars = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] chars = digits.toCharArray();
        int first = digits.charAt(0) - '0';
        for(int i = 0; i < numbersChars[first].length(); i++) {
            StringBuffer sb = new StringBuffer();
            sb.append(numbersChars[first].charAt(i));
            temp.add(sb);
        }
        for(int i = 1; i < chars.length; i++) {
            int tempInt = digits.charAt(i) - '0';
            while(!temp.isEmpty()) {
                StringBuffer currentSB = temp.pop();
                for(int j = 0; j < numbersChars[tempInt].length(); j++) {
                    StringBuffer currentSB1 = new StringBuffer(currentSB);
                    currentSB1.append(numbersChars[tempInt].charAt(j));
                    temp2.push(currentSB1);
                }
            }
            while(!temp2.isEmpty()) {
                temp.push(temp2.pop());
            }
        }

        while(!temp.isEmpty()) {
            ans.add(temp.pop().toString());
        }

        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String digit = sc.nextLine();
        sc.close();
        List<String> ans = letterCombinations(digit);
        for(String s : ans) {
            System.out.println(s + " ");
        }
        System.out.println();
    }
}
