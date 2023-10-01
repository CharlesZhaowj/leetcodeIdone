package com.pickbucket.leetcode.doublepointer.slidingwindow;

/**
 * 有点坑，你再想想罢
 */
public class P_560_subarraySumIsK {

    public int subarraySum(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int cur = nums[0];
        int cnt = 0;
        while (r < nums.length) {
            if (cur < k) {
                r++;
                cur += nums[r];
            } else if (cur > k) {
                cur -= nums[l];
                l++;
            } else {
                cnt++;
                r++;
                if (r < nums.length) {
                    cur += nums[r];
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
