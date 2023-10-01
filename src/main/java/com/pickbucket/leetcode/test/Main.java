package com.pickbucket.leetcode.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//         Scanner in = new Scanner(System.in);
//         while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//             int a = in.nextInt();
//             int b = in.nextInt();
//             System.out.println(a + b);
//         }

        Scanner in = new Scanner(System.in);
        int serviceNum = in.nextInt();
        int requestNum = in.nextInt();
        int[] times = new int[70]; // todo 改回来
        for (int i = 0; i < requestNum; i++) {
            int time = in.nextInt();
            int haoshi = in.nextInt();
            times[time] = haoshi;
        }
        int load[] = new int[serviceNum + 1];
        Map<Integer, Integer> loadDetail = new HashMap<>();
        for (int i = 1; i <= serviceNum; i++) {
            loadDetail.put(i, -1);
        }
        int cur = 1;
        for (int i = 0; i < times.length; i++) {
            if (times[i] > 0) {
                for (int j = 0; j < serviceNum; j++) {
                    int now = cur + j > 3 ? cur + j - 3 : cur + j;
                    if (loadDetail.get(now) <= i) {
                        loadDetail.put(now, i+times[i]);
                        load[now] += times[i];
                        cur = now;
                        break;
                    }
                }
            }
        }
        int max = 1;
        for (int i = 1; i <= serviceNum; i++) {
            if (max < load[i]) {
                max = load[i];
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= serviceNum; i++) {
            if (max == load[i]) {
                ans.add(i);
            }
        }
        for (int i = 0; i < ans.size() - 1; i++) {
            System.out.print(i + " ");
        }
        System.out.println(ans.size() - 1);
    }
}
