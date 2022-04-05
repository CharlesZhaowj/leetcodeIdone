package com.pickbucket.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P_564_findTheClosestPalindrome {
    public String nearestPalindromic(String n) {
        long ans = -1;
        long selfValue = Long.parseLong(n);
        Integer length = n.length();
        List<Long> candidateValues = new ArrayList<>(4);
        candidateValues.add((long)Math.pow(10, length) + 1);
        candidateValues.add((long)Math.pow(10, length-1) - 1);
        long selfPrefix = Long.parseLong(n.substring(0, (length + 1) / 2));
        for (long i = selfPrefix - 1; i <= selfPrefix + 1; i++) {
            StringBuffer sb = new StringBuffer();
            String prefix = String.valueOf(i);
            sb.append(prefix);
            StringBuffer suffix = new StringBuffer(prefix).reverse();
            sb.append(suffix.substring(length & 1));
            String candidate = sb.toString();
            candidateValues.add(Long.parseLong(candidate));
        }

        for (long candidate : candidateValues) {
            if (candidate != selfValue) {
                if (ans == -1 ||
                        Math.abs(candidate - selfValue) < Math.abs(ans - selfValue) ||
                        Math.abs(candidate - selfValue) == Math.abs(ans - selfValue) && candidate < ans) {
                    ans = candidate;
                }
            }
        }
        return Long.toString(ans);
    }

    public static void main(String[] args) {
//        P_564_findTheClosestPalindrome find = new P_564_findTheClosestPalindrome();
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        System.out.println(find.nearestPalindromic(s));
//        List<String> charsInNumList = Arrays.asList("", "", "abc", "def",
//                "ghi", "jkl", "mno",
//                "pqrs", "tuv", "wxyz");
        System.out.println(0b10101010101010101010101);
    }


}
