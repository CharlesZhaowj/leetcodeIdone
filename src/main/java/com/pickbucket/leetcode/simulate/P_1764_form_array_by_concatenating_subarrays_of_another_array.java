package com.pickbucket.leetcode.simulate;

public class P_1764_form_array_by_concatenating_subarrays_of_another_array {

    public boolean canChoose(int[][] groups, int[] nums) {
        int groupCnt = 0;
        for (int i = 0; i < nums.length; ) {
            if (groupCnt >= groups.length) {
                return true;
            } else if (groups[groupCnt] == null || groups[groupCnt].length == 0) {
                groupCnt++;
            } else if (contains(groups[groupCnt], nums, i)) {
                i += groups[groupCnt].length;
                groupCnt++;
            } else {
                i++;
            }
        }
        if (groupCnt == groups.length) {
            return true;
        } else {
            return false;
        }
//
    }

    public static boolean contains(int[] group, int[] nums, int curNums) {
        if (curNums + group.length > nums.length) {
            return false;
        }
        for (int i = 0; i < group.length; i++) {
            if (group[i] != nums[curNums + i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int [][] groups = new int[][] {{1,-1,-1},{3,-2,0}};
        int[] nums = new int[]{1,-1,0,1,-1,-1,3,-2,0};

//        int[][] groups = new int[][]{{9099312, -7882487, -1441304, 6624042, -6043305}};
//        int[] nums = new int[]{-1441304, 9099312, -7882487, -1441304, 6624042, -6043305, -1441304};

//        int [][] groups = new int[][] {{1,2,3},{3,4}};
//        int[] nums = new int[]{7,7,1,2,3,4,7,7};
        System.out.println(new P_1764_form_array_by_concatenating_subarrays_of_another_array().canChoose(groups, nums));
    }
}
