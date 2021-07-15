package autumn.qunar;

import java.util.ArrayList;
import java.util.Scanner;

public class LianXvZiShuZu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        int res = maxSubArray(list);
        System.out.println(res);
    }
    private static int maxSubArray(ArrayList<Integer> nums) {
        int res = nums.get(0);
        int sum = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            sum = Math.max(nums.get(i), sum + nums.get(i));
            res = Math.max(res, sum);
        }
        return res;
    }
}
