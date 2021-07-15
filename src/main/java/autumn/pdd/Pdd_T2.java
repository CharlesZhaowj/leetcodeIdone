package autumn.pdd;

import java.util.Scanner;

public class Pdd_T2 {
    /**
     * PDD T2 考虑是不是字符串的输入再做一些处理
     * 可能得用动态规划
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] point = new int[n];
        String[] ticket = new String[m];
        int l = 0;
        sc.nextLine();
        while(sc.hasNext()) {
            ticket[l] = sc.nextLine();
            l++;
            if(l >= m)
                break;
        }
        int max = 0;
        int hasMax = 0;
        int maxPlayer = 0;
        for(int i = 0; i < n; i++) {
            point[i] = 0;
            for(int j = 0; j < m; j++) {
              point[i] += 26 - (ticket[j].charAt(i) - 'a');
            }
            if(point[i] == max) {
                hasMax++;
            }
            if(point[i] > max) {
                max = point[i];
                hasMax = 1;
                maxPlayer = i;
            }

        }
        if(hasMax == 1) {
            System.out.println(maxPlayer);
        }
        else {
            System.out.println(-1);
        }
    }
}
