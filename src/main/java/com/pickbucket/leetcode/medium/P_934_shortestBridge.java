package com.pickbucket.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class P_934_shortestBridge {

    public int shortestBridge(int[][] grid) {
        int[][] direct = new int[][]{{0,1}, {0, -1}, {1,0}, {-1,0}};
        List<int[]> anIslands = new ArrayList<>();
        Queue<int[]> pointInfo = new ArrayDeque<>();
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && pointInfo.isEmpty()) {
                    grid[i][j] = -1;
                    pointInfo.offer(new int[]{i, j});
                }
            }
        }
        // bfs 染色
        while(!pointInfo.isEmpty()) {
            int[] cur = pointInfo.poll();
            anIslands.add(cur);
            for(int[] direc : direct) {
                int x = cur[0]+direc[0];
                int y = cur[1]+direc[1];
                if (0 < x  && x < n && 0 < y && y < n) {
                    if (grid[x][y] == 1) {
                        grid[x][y] = -1;
                        pointInfo.offer(new int[]{x, y});
                    }
                }
            }
        }
        // bfs 按圈找
        int step = 0;
        for (int[] islandPoint : anIslands) {
            pointInfo.offer(islandPoint);
        }
        while (!pointInfo.isEmpty()) {
            int k = pointInfo.size();
            for (int i = 0; i < k; i++) {
                int[] point = pointInfo.poll();
                for(int[] direc : direct) {
                    int x = point[0]+direc[0];
                    int y = point[1]+direc[1];
                    if (0 <= x && x < n && 0 <= y && y < n) {
                        if (grid[x][y] == 1) {
                            return step;
                        } else if (grid[x][y] == 0) {
                            pointInfo.add(new int[]{x, y});
                        }
                    }
                }
            }
            step++;
        }
        Character c = 'a';
        return -1;
    }

    public static void main(String[] args) {
        P_934_shortestBridge invoker = new P_934_shortestBridge();
        // expected 1
        // invoker.shortestBridge(new int[][]{{0,1}, {1,0}});
        // expected 2
        invoker.shortestBridge(new int[][]{{0,1,0},{0,0,0},{0,0,1}});
    }
}
