package com.pickbucket.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 预处理先出最大和最小值也可以做
 */

public class P_1380_luckyNumbers {
    public List<Integer> luckyNumbers (int[][] matrix) {
        Set<Integer> ans = new HashSet();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (isLucky(i, j, matrix)) {
                    ans.add(matrix[i][j]);
                }
            }
        }
        return new ArrayList<>(ans);
    }

    public static boolean isLucky(int x, int y, int[][] matrix) {
        int num = matrix[x][y];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][y] < num) {
                return false;
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[x][j] > num) {
                return false;
            }
        }
        return true;
    }
}
