package com.pickbucket.leetcode.test;

import java.util.Scanner;

public class MainTemp {

    public static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static void main(String[] args) {
//         Scanner in = new Scanner(System.in);
//         while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//             int a = in.nextInt();
//             int b = in.nextInt();
//             System.out.println(a + b);
//         }

        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        int[][] map = new int[row+1][col+1];
        int stationNum = in.nextInt();
        for (int i = 0; i < stationNum; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            // mark station
            map[x][y] = -1;
        }
        int commandNum = in.nextInt();
        in.nextLine();
        for (int i = 0; i < commandNum; i++) {
            String s = in.nextLine();
            String[] splits = s.split(" ");
            if ("add".equals(splits[0])) {
                int x = Integer.parseInt(splits[1]);
                int y = Integer.parseInt(splits[2]);
                map[x][y] = -1;
            } else if ("delete".equals(splits[0])) {
                int x = Integer.parseInt(splits[1]);
                int y = Integer.parseInt(splits[2]);
                deleteStation(map, x, y);
            }
        }
        // mark all the sign
        for (int x = 1; x < map.length; x++) {
            for (int y = 1; y < map[0].length; y++) {
                if (map[x][y] == -1) {
                    for(int[] dir : dirs) {
                        int newX = x + dir[0];
                        int newY = y + dir[1];
                        if (newX >= 1 && newX < row && newY >= 1 && newY < col) {
                            if (map[newX][newY] != -1) {
                                map[newX][newY] += 1;
                            }
                        }
                    }
                }
            }
        }
        // count sign
        int cnt = 0;
        for (int x = 1; x < map.length; x++) {
            for (int y = 1; y < map[0].length; y++) {
                if (map[x][y] > 0) {
                    cnt += map[x][y];
                }
            }
        }
        System.out.println(cnt);
    }

    private static void deleteStation(int[][] map, int x, int y) {
        int row = map.length-1;
        int col = map[0].length-1;
        map[x][y] = 0;
        for(int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX >= 1 && newX <= row && newY >= 1 && newY <= col) {
                if (map[newX][newY] == -1) {
                    map[newX][newY] = 0;
                }
            }
        }
    }
}
