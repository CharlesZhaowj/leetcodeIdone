package com.pickbucket.leetcode.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        // while (in.hasNextInt()) { // 注意 while 处理多个 case
        //     int a = in.nextInt();
        //     int b = in.nextInt();
        //     System.out.println(a + b);
        // }
        String s = in.nextLine();
        String[] sList = s.split("/.");
        long rawAns = Integer.parseInt(sList[0]);
        if (sList[1].charAt(0) < '5') {
            System.out.println(rawAns);
        } else {
            System.out.println(rawAns + 1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            entry.getKey();
        }
    }
}
