package com.pickbucket.leetcode.simulate.presum;

public class P_560_subarraySumIsK {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] presum = new int[n + 5];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i-1] + nums[i-1];
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                if (presum[j] - presum[i] == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    /**
     * 输入：nums = [1,1,1], k = 2
     * 输出：2
     *
     * 输入：nums = [1,2,3], k = 3
     * 输出：2
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(new P_560_subarraySumIsK().subarraySum(nums, 3));
    }
}
