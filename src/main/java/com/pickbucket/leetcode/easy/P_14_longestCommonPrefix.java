package com.pickbucket.leetcode.easy;

public class P_14_longestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int length = 0;
        boolean end = false;
        while (true) {
            for (int i = 0; i < strs.length-1; i++) {
                if (length >= strs[i].length() || length >= strs[i+1].length() ||
                        strs[i].charAt(length) != strs[i+1].charAt(length)) {
                    end = true;
                    break;
                }
            }
            if (end) {
                break;
            }
            length++;
        }
        if(length == 0) {
            return "";
        } else {
            return strs[0].substring(0, length);
        }
    }

    public static void main(String[] args) {
        String[] strs = {"kenai", "kenai"};
        System.out.println(longestCommonPrefix(strs));
    }
}
