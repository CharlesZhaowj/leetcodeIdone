package leetcode;

// import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class P_128 {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return 1;
        }
        Set<Integer> set = new HashSet<>();
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            int leftCnt = 0;
            int rightCnt = 0;
            for(int j = nums[i]+1; ; j++) {
                if(set.contains(j)) {
                    rightCnt++;
                } else {
                    break;
                }
            }
            for(int j = nums[i]-1; ; j--) {
                if(set.contains(j)) {
                    leftCnt++;
                } else {
                    break;
                }
            }
            if(leftCnt + rightCnt + 1 > maxLen) {
                maxLen = leftCnt + rightCnt + 1;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(new P_128().longestConsecutive(nums));
    }
}
