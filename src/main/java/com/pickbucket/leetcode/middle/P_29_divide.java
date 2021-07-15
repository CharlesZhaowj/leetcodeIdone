package com.pickbucket.leetcode.middle;

// 位运算做除法（很有趣，相当之有趣）
public class P_29_divide {
    int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;
        //因为带符号整数的范围为-2^n~2^n-1，故存在一种特殊情况

        //取两数的绝对值
        long m = Math.abs((long)dividend), n = Math.abs((long)divisor), res = 0;
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;//注意此处异或的作用
        if (n == 1) {
            return (int)(sign == 1 ? m : -m);
        }

        while (m >= n) {
            long t = n, p = 1;
            while (m >= (t << 1)) {
                p <<= 1;
                t <<= 1;
            }
            res += p;
            m -= t;
        }

        return (int)(sign > 0 ? res : -res);
    }
}
