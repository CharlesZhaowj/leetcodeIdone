package com.pickbucket.leetcode.simulate;

public class P_581_findUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (minn < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minn = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }

    /**
     * 输入：nums = [2,6,4,8,10,9,15]
     * 输出：5
     *
     * 输入：nums = [1,2,3,4]
     * 输出：0
     *
     * 输入：nums = [1]
     * 输出：0
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new P_581_findUnsortedSubarray().findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
    }
}
