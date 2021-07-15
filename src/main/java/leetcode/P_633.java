package leetcode;

import java.util.Scanner;

public class P_633 {
    public static boolean judgeSquare(int c) {
        int l = 0;
        int r = (int)Math.sqrt(c);
        while(l <= r) {
            if(l*l + r*r == c) {
                return true;
            } else if(l*l + r*r > c) {
                r--;
            } else if(l*l + r*r < c) {
                l++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println(judgeSquare(i));
    }
}
