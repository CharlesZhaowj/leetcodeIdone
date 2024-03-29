package com.pickbucket.leetcode.simulate;

public class P_27_removeElement {
    public int removeElement(int[] nums, int val) {
        int current = 0;
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == val) {
                i++;
            } else {
                nums[current] = nums[i];
                current++;
                i++;
            }
        }
        return current;
    }
}
