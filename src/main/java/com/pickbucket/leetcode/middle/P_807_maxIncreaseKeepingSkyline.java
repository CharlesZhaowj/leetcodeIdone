package com.pickbucket.leetcode.middle;


import java.util.Scanner;

public class P_807_maxIncreaseKeepingSkyline {
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int sum = 0;
        if(grid == null) {
            return sum;
        }
        int[] vertical = new int[grid.length];
        int[] horizontal = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (vertical[i] < grid[i][j]) {
                    vertical[i] = grid[i][j];
                }
                if (horizontal[j] < grid[i][j]) {
                    horizontal[j] = grid[i][j];
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum += (Math.min(horizontal[j], vertical[i]) - grid[i][j]) > 0 ?
                        Math.min(horizontal[j], vertical[i]) - grid[i][j] : 0;
            }
        }
        return sum;
    }
    /*
4 4
3 0 8 4 2 4 5 7 9 2 6 3 0 3 1 0
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] array = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        System.out.println(maxIncreaseKeepingSkyline(array));
    }
}
