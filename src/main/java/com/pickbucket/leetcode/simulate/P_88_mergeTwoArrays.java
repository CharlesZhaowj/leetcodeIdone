package com.pickbucket.leetcode.simulate;

public class P_88_mergeTwoArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int first = m - 1;
        int second = n - 1;
        int cur = m + n - 1;
        while (first >= 0 || second >= 0) {
            // 判NPE
            if (first < 0 || (second >= 0 && nums1[first] < nums2[second])) {
                nums1[cur] = nums2[second];
                cur--;
                second--;
            } else {
                nums1[cur] = nums1[first];
                cur--;
                first--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        new P_88_mergeTwoArrays().merge(nums1, 3, nums2, 3);
    }
}
