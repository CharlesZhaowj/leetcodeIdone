package autumn.pdd;

import java.util.Arrays;
import java.util.Scanner;

public class Pdd_T3 {
    /**
     * 有N个货物（0<=N<=1024）
     * 每个货物的重量是W（100<=W<=300）
     * 如果每辆车最多的载重为300
     * 请问最少需要多少辆车才能运输所有货物。
     */
    /**
     * 想用贪心赌一把,55%
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        String s = sc.nextLine();
        String[] nums = s.split(" ");
        Integer[] weights = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++) {
            weights[i] = (Integer.parseInt(nums[i]));
        }
        // 从小到大排序
        Arrays.sort(weights);
        boolean[] used = new boolean[weights.length];
        for(int i = 0; i < weights.length; i++) {
            used[i] = false;
        }
        int countCar = 0;
        for(int i = 0; i < weights.length; i++) {
            if(!used[i]){
                used[i] = true;
                int tempSum = weights[i];
                for(int j = weights.length-1; j >= 0; j--) {
                    if(!used[j] && weights[j] + tempSum <= 300) {
                        used[j] = true;
                        tempSum += weights[j];
                    }
                }
                countCar++;
            }
        }
        System.out.println(countCar);
    }
}
