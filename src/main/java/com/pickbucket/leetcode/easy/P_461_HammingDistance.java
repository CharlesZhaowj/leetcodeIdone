package com.pickbucket.leetcode.easy;

public class P_461_HammingDistance {
    public static int hammingDistance(int x, int y) {
       int d = x ^ y;
       int ans = 0;
       while (d > 0) {
           d = d & d-1;
           ans++;
       }
       return ans;
    }

    public int hammingDistanceBetter(int x, int y) {
        int ans = 0;
        while ((x | y) != 0) {
            int a = x & 1, b = y & 1;
            ans += a ^ b;
            x >>= 1; y >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
}
