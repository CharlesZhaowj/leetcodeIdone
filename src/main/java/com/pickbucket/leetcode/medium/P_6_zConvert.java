package com.pickbucket.leetcode.medium;

import java.util.Scanner;

public class P_6_zConvert {
    public static String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        int strLen = s.length();
        int lLength = numRows + numRows - 2;
        int times = s.length() % lLength == 0 ? s.length() / lLength : s.length() / lLength + 1;
        StringBuffer sb = new StringBuffer();
        // firstLine
        for (int j = 0; j < times; j++) {
            if (j * lLength < strLen) {
                sb.append(s.charAt(j*lLength));
            }
        }
        for (int i = 1; i < numRows - 1; i++) {
            for (int j = 0; j < times; j++) {
                if (j * lLength + i < strLen) {
                    sb.append(s.charAt(j * lLength + i));
                }
                if (j * lLength + lLength - i  < strLen) {
                    sb.append(s.charAt(j * lLength + lLength - i));
                }
            }
        }
        // lastLine
        for (int j = 0; j < times; j++) {
            if (j * lLength + numRows - 1 < strLen) {
                sb.append(s.charAt(j * lLength + numRows - 1));
            }
        }
        return sb.toString();
    }

    public static String convert2(String s, int numRows) {
        int length = s.length();
        if (numRows == 1 || length <= numRows) {
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }
        int mode = numRows * 2 - 2;
        int x = 0;
        for (int i = 0; i < length; i++) {
            sbs[x].append(s.charAt(i));
            if (i % mode < numRows - 1) {
                x++;
            } else {
                x--;
            }
        }
        StringBuilder finalSb = new StringBuilder();
        for (StringBuilder sb : sbs) {
            finalSb.append(sb);
        }
        return finalSb.toString();
    }

    /*
    PAYPALISHIRING 3 PAHNAPLSIIGYIR

    PAYPALISHIRING 4 PINALSIGYAHRPI
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Integer i = sc.nextInt();
        System.out.println(convert2(s, i));
        sc.close();
    }
}
