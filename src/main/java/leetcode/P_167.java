package leetcode;

public class P_167 {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length < 2) {
            return null;
        }
        int[] ans = new int[2];
        int l = 0;
        int r = numbers.length - 1;
        while(l < r) {
            if(numbers[l] + numbers[r] < target) {
                l++;
            } else if(numbers[l] + numbers[r] > target) {
                r--;
            } else {
                ans[0] = numbers[l];
                ans[1] = numbers[r];
                return ans;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int target = 3;
        P_167 p = new P_167();
        int[] ans = p.twoSum(a, 3);
        for(int i : ans) {
            System.out.println(i);
        }
    }
}
