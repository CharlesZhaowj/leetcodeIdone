package autumn.qunar;

import java.util.Scanner;

/**
 * 一点感想：你的题目还是刷得太少了啊兄弟= =
 */
public class MaZouRi {
    private static Scanner sc = new Scanner(System.in);
    private static int[][] d = new int[][]{{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, -2}, {1, 2}, {-1, -2}, {-1, -2}};
    private static int res = Integer.MAX_VALUE;
    //起点终点
    private static int stax = sc.nextInt(),stay = sc.nextInt(), ex = sc.nextInt(), ey = sc.nextInt();
    private static boolean[][] vis = new boolean[9][9];
    public static void main(String[] args) {
        solve(stax, stay, 0);
        System.out.println(res);
    }

    private static void solve(int x, int y, int sum) {
        if (sum < res) {
            if (x == ex && y == ey) {
                res = sum;
            } else {
                for(int i = 0; i < 8; ++i) {
                    int tmpx = x + d[i][0];
                    int tmpy = y + d[i][1];
                    if (tmpx >= 1 && tmpx <= 8 && tmpy >= 1 && tmpy <= 8 && !vis[tmpx][tmpy]) {
                        vis[tmpx][tmpy] = true;
                        solve(tmpx, tmpy, sum + 1);
                        vis[tmpx][tmpy] = false;
                    }
                }
            }
        }
    }
}
