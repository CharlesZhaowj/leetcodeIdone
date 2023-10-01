package com.pickbucket.leetcode.deque;

import java.util.Arrays;
import java.util.LinkedList;

public class P_239_maxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int ans[] = new int[nums.length - k + 1];
        LinkedList<Integer> deque = new LinkedList<>();
        for (int right = 0; right < nums.length; right++) {
            while(!deque.isEmpty() && nums[right] >= nums[deque.peekLast()]) {
                deque.removeLast();
            }

            // 只能存下标，因为需要判断元素的位置
            deque.addLast(right);

            int left = right - k + 1;
            if (deque.peekFirst() < left) {
                deque.removeFirst();
            }

            // 窗口形成，那么开始计算
            if (left >= 0) {
                ans[left] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.stream(new P_239_maxSlidingWindow().maxSlidingWindow(new int[]{7,2,4}, 2)).toArray());
    }
}
