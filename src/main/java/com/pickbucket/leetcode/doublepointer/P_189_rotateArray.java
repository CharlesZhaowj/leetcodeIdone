package com.pickbucket.leetcode.doublepointer;

public class P_189_rotateArray {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int indexOri = nums[0];
        int curIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int nextIndex = (curIndex + k) % nums.length;
            int temp = indexOri;
            indexOri = nums[nextIndex];
            nums[nextIndex] = temp;
            curIndex = nextIndex;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-100,3,99};
        new P_189_rotateArray().rotate(nums, 2);
    }
}
