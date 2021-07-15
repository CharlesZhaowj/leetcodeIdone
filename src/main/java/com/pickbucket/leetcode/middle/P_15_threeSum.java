package com.pickbucket.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_15_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        if(nums != null && nums.length > 2){
            Arrays.sort(nums);
            for(int i = 0; i < nums.length - 2; ){
                int j = i+1;
                int k = nums.length - 1;
                while(j < k){
                    // 三数之和恰好为0时
                    if(nums[j] + nums[k] == -nums[i]){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        ans.add(list);

                        j++;
                        k--;

                        while(j < k && nums[j] == nums[j-1]){
                            j++;
                        }

                        while(j < k && nums[k] == nums[k+1]){
                            k--;
                        }
                    } else if(nums[i] + nums[j] + nums[k] < 0){
                        j++;
                        while(j < k && nums[j] == nums[j-1]){
                            j++;
                        }
                    } else {
                        k--;
                        while(j < k && nums[k] == nums[k+1]){
                            k--;
                        }
                    }
                }

                i++;
                while(i < nums.length - 2 && nums[i] == nums[i-1]){
                    i++;
                }
            }
        }
        return ans;
    }
}
