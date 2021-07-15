package com.pickbucket.leetcode.others;

import javafx.util.Pair;

import java.util.*;

public class BFS {
    public static int minPathLength(int[][] grids, int tr, int tc) {
        final int[][] direction = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        final int m = grids.length, n = grids[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));
        int pathLength = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;
            while(size-- > 0) {
                Pair<Integer, Integer> cur = queue.poll();
                for(int[] d : direction) {
                    int nr = cur.getKey() + d[0], nc = cur.getValue() + d[1];
                    Pair<Integer, Integer> next = new Pair<>(nr, nc);
                    if (next.getKey() < 0 || next.getValue() >= m || next.getKey() < 0 || next.getValue() >= n) {
                        continue;
                    }
                    grids[next.getKey()][next.getValue()] = 0;
                    if (next.getKey() == tr && next.getValue() == tc) {
                        return pathLength;
                    }
                    queue.add(next);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[][] grids = {{1,1,0,1},{1,0,1,0},{1,1,1,1},{1,0,1,1}};
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(minPathLength(grids, x, y));
    }
}
