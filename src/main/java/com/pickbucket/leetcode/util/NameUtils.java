package com.pickbucket.leetcode.util;

import java.util.Scanner;

public class NameUtils {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input problem num:");
        String num = sc.nextLine();
        System.out.println("Input proble title:");
        String title = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        System.out.println('A'-'a');
        System.out.println(sb.append("P_").append(num).append("_").append(handleTitle(title)));
    }

    public static String handleTitle(String title) {
        if (title == null || title.length() == 0) {
            return title;
        }
        char[] titleChar = title.toCharArray();
        char[] replaced = new char[titleChar.length];
        int replacedCur = 0;
        for (int i = 0; i < titleChar.length; i++) {
            if (titleChar[i] == '-') {
                continue;
            } else if (i - 1 > 0 && titleChar[i-1] == '-') {
                replaced[replacedCur] = (char)(titleChar[i] + ('A' - 'a')) ;
//                replaced[replacedCur] = titleChar[i];
            } else {
                replaced[replacedCur] = titleChar[i];
            }
            replacedCur++;
        }
        return String.valueOf(replaced).trim();
    }
}
