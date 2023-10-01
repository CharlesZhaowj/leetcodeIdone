package com.pickbucket.leetcode.doublepointer.slidingwindow;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 滑动窗口
 */
public class P_3_lengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int l = 0, r = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (r < s.length()) {
            if (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            } else {
                if (r-l+1 > max) {
                    max = r-l+1;
                }
                set.add(s.charAt(r));
                r++;
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstring_2(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public static int lengthOfLongestSubstring_3(String s) {
        // 双指针
        int max = 0;
        int l = 0;
        int r = 0;
        Set<Character> subStrChar = new HashSet();
        // 双指针的模版？感觉最好还是while吧，一left一right
        while (r < s.length()) {
            char curR = s.charAt(r);
            if (subStrChar.contains(curR)) {
                subStrChar.remove(s.charAt(l));
                l++;
            } else {
                max = Math.max(r - l + 1, max);
                subStrChar.add(curR);
                r++;
            }
        }
        return max;
    }

    /*
    abcabcbb    3
    bbbbb       1
    pwwkew      3
     */
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring_3("pwwkew"));
    }
}
