package com.pickbucket.leetcode.easy;

/**
 *  编写一个函数来查找字符串数组中的最长公共前缀。
 *
 *  如果不存在公共前缀，返回空字符串 ""。
 *
 *  示例 1:
 *
 *  输入: ["flower","flow","flight"]
 *  输出: "fl"
 *  示例 2:
 *
 *  输入: ["dog","racecar","car"]
 *  输出: ""
 *  解释: 输入不存在公共前缀。
 *  说明:
 *
 *  所有输入只包含小写字母 a-z 。
 *
 *  PS: 性能最好的答案在找前缀的时候使用了二分，这实在是太优秀了~
 */
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
