package com.pickbucket.leetcode.easy;

public class P_121_maxProfit {
    public int maxProfit(int[] prices) {
        int ans = 0;
        if(prices == null || prices.length <= 1) {
            return ans;
        }
        int max = 0;
        int min = prices[0];
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < min)
                min = prices[i];
            if(prices[i] - min > max) {
                max = prices[i] - min;
            }
        }

        ans = max;

        return ans;
    }
}
