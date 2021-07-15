package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 思路大概是这样的，但是感觉有更好的思路才对啊
public class P_18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums != null && nums.length > 3) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 3; ) {
                for (int j = i + 1; j < nums.length - 2; ) {
                    int k = j + 1;
                    int l = nums.length - 1;
                    while(k < l) {
                        if(nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            temp.add(nums[l]);
                            ans.add(temp);
                            while(k < l && nums[k] == nums[k+1]) {
                                k++;
                            }
                            while(k < l && nums[l] == nums[l-1]) {
                                l--;
                            }
                        } else if(nums[i] + nums[j] + nums[k] + nums[l] < target) {
                            k++;
                            while(k < l && nums[k] == nums[k+1]) {
                                k++;
                            }
                        } else {
                            l--;
                            while(k < l && nums[l] == nums[l-1]) {
                                l--;
                            }
                        }
                    }
                    j++;
                    while(j < nums.length - 2 && nums[j] == nums[j + 1]) {
                        j++;
                    }
                }
                i++;
                while(i < nums.length - 3 && nums[i] == nums[i+1]) {
                    i++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> ans = fourSum(nums, target);
        System.out.println(ans.size());
    }
}
