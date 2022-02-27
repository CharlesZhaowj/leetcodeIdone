package com.pickbucket.leetcode.medium;

public class P_915_partitionDisjoint {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMin = new int[n];
        leftMax[0] = nums[0];
        rightMin[n - 1] = nums[n-1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(nums[i], leftMax[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        }
        for (int i = 0; i < n - 1; ++i) {
            if (leftMax[i] <= rightMin[i + 1]) return i + 1;
        }
        return -1;
    }
}
