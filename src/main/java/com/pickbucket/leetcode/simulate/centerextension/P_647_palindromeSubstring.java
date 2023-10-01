package com.pickbucket.leetcode.simulate.centerextension;

import java.util.HashMap;

/**
 * 注：这一题还可以用动态规划，dp[i][j] = dp[i+1][j-1] && sChar[i] == sChar[j]
 * 本质上还是剪枝优化
 */
public class P_647_palindromeSubstring {
    public int countSubstrings(String s) {
        int length = s.length();
        int cnt = 0;
        for (int i = 0; i < 2*length - 1; i++) {
            int l = i / 2;
            int r = i / 2 + i % 2;
            while(l >= 0 && r < length && s.charAt(l) == s.charAt(r)) {
                cnt++;
                l--;
                r++;
            }
        }
        return cnt;

    }

    /**
     * 输入：s = "abc"
     * 输出：3
     * 解释：三个回文子串: "a", "b", "c"
     * 示例 2：
     *
     * 输入：s = "aaa"
     * 输出：6
     * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new P_647_palindromeSubstring().countSubstrings( "aaa"));
    }

}
