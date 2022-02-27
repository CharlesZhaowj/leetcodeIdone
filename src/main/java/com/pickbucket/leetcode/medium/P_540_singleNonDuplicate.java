package com.pickbucket.leetcode.medium;

public class P_540_singleNonDuplicate {

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (mid % 2 == 0) {
                if (mid + 1 < n && nums[mid] == nums[mid + 1]) l = mid + 1;
                else r = mid;
            } else {
                if (mid - 1 >= 0 && nums[mid - 1] == nums[mid]) l = mid + 1;
                else r = mid;
            }
        }
        return nums[r];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,3,7,7,10,11,11};
        System.out.println(new P_540_singleNonDuplicate().singleNonDuplicate(nums));
    }
}
