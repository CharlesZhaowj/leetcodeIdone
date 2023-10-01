package com.pickbucket.leetcode.dynamicprogram;

import java.util.Arrays;

public class DicesProbability {
    public double[] dicesProbability(int n) {
        int[][] ans = new int[n + 1][67];
        for (int i = 1; i <= n; i++) {
            // cause j must bigger than times
            for (int j = i; j <= i * 6; j++) {
                if (i == 1) {
                    // initialize
                    ans[i][j] = 1;
                } else {
                    for (int k = 1; k <= 6; k++) {
                        // formula
                        if (j - k < 0) {
                            continue;
                        }
                        ans[i][j] += ans[i - 1][j - k];
                    }
                }
            }
        }
        double[] ansPos = new double[n * 6 - (n - 1)];
        double times = Math.pow(6, n);
        for (int i = 0; i < ansPos.length; i++) {
            ansPos[i] = ans[n][i + n] / times;
        }
        return ansPos;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new DicesProbability().dicesProbability(1)));
        System.out.println(Arrays.toString(new DicesProbability().dicesProbability(2)));
    }
}
