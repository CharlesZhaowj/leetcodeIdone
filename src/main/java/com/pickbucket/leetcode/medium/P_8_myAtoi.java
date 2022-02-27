package com.pickbucket.leetcode.medium;

import java.util.Scanner;

// 先把字符串转为char数组，效率会高很多的！！！！
public class P_8_myAtoi {
    public static int myAtoi(String str) {
        str = str.trim();
        if(str == null || str.length() < 1) {
            return 0;
        }
        long ans = 0;
        boolean isMinus = false;
        int index = 0;
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            isMinus = true;
            index++;
        }
        while (index < str.length()) {
            if (str.charAt(index) <= '9' && str.charAt(index) >= '0') {
                ans = ans * 10 + (str.charAt(index) - '0');
            } else {
                break;
            }
            if (ans > Integer.MAX_VALUE) {
                break;
            }
            index++;
        }

        // 差一步正负数的转化
        if (isMinus) {
            ans = -ans;
        }

        if (ans > (long)Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (ans < (long)Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int)ans;
        }
    }

    /*
    42
       -42
    4193 with words
    words and 987
    -91283472332
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(myAtoi(sc.nextLine()));
        sc.close();
    }
}
