package com.pickbucket.leetcode.easy;

import java.util.Objects;

public class P_1598_crawlerLogFolder {

    public int minOperations(String[] logs) {
        int cnt = 0;
        for (String s : logs) {
            if (Objects.equals("../", s) && cnt > 0) {
                cnt--;
            } else if (Objects.equals("./", s)) {
                continue;
            } else {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        String input = "[\"./\",\"../\",\"./\"]";
        String[] inputStr = input.split(",");
        System.out.println(new P_1598_crawlerLogFolder().minOperations(inputStr));
    }
}
