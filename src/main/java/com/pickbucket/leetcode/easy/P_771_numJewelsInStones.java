package com.pickbucket.leetcode.easy;

import java.util.TreeSet;

public class P_771_numJewelsInStones {
    public int numJewelsInStones(String J, String S) {
        int ans = 0;
        if(J.length() == 0 || S.length() == 0) {
            return ans;
        }
        TreeSet<Character> set = new TreeSet<>();
        char[] jewel = J.toCharArray();
        for(char j : jewel) {
            set.add(j);
        }
        for(int i = 0; i < S.length(); i++) {
            if(set.contains(S.charAt(i))) {
                ans++;
            }
        }
        return ans;
    }
}
