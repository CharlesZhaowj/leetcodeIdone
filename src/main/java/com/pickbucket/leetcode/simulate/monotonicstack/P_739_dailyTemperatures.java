package com.pickbucket.leetcode.simulate.monotonicstack;

import java.util.Arrays;
import java.util.Stack;

public class P_739_dailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty()) {
                if (temperatures[stack.peek()] >= temperatures[i]) {
                    stack.push(i);
                    break;
                } else {
                    int location = stack.pop();
                    ans[location] = i - location;
                }
            }
            if (stack.isEmpty()) {
                stack.push(i);
            }
        }
        while(!stack.isEmpty()) {
            ans[stack.pop()] = 0;
        }
        return ans;
    }

    /**
     * 输入: temperatures = [73,74,75,71,69,72,76,73]
     * 输出: [1,1,4,2,1,1,0,0]
     *
     * 输入: temperatures = [30,40,50,60]
     * 输出: [1,1,1,0]
     *
     * 输入: temperatures = [30,60,90]
     * 输出: [1,1,0]
     *
     * [89,62,70,58,47,47,46,76,100,70]
     * [8,1,5,4,3,2,1,1,0,0]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] temp = new int[]{89,62,70,58,47,47,46,76,100,70};
        System.out.println(Arrays.toString(new P_739_dailyTemperatures().dailyTemperatures(temp)));
    }

}
