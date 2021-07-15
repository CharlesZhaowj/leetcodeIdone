package com.pickbucket.leetcode.middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P_22_generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backTrace(ans, "", n, n);
        return ans;
    }

    // helpGenerateParenthesis
    public void backTrace(List<String> ans, String subList, int left, int right) {
        if (left == 0 && right == 0) {
            ans.add(subList);
            return;
        }
        if (left > 0) {
            backTrace(ans, subList + "(", left - 1, right);
        }
        if (left < right) {
            backTrace(ans, subList + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        P_22_generateParenthesis testP = new P_22_generateParenthesis();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        List<String> ans = testP.generateParenthesis(num);
        for(String s : ans) {
            System.out.println(s);
        }
    }
}
