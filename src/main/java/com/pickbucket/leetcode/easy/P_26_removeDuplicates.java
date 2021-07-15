package com.pickbucket.leetcode.easy;

public class P_26_removeDuplicates {
    public int removeDuplicates(int[] nums) {
        int current = 0;
        int i = 0;
        while(i < nums.length) {
            while(i+1 < nums.length && nums[i] == nums[i+1]) {
                i++;
            }
            nums[current] = nums[i];
            current++;
            i++;
        }
        return current;
    }
}
