package autumn.pdd;

import java.util.Scanner;

public class Pdd_T1 {
    /**
     * time 18/07/22
     * PDD Pdd_T1
     * @param args
     */
    public static void main(String[] args) {
        String[] name = {"Alice", "Bob", "Cathy", "Dave"};
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int i = 1;
        int cnt = 0;
        long sum = 0;
        while(sum < n) {
            sum += i*4;
            i *= 2;
            cnt++;
        }
        long over = sum-n;
        i /= 2;
        for(int j = 0; j < 4; j++) {
            if(i*(j+1) > over) {
                System.out.println(name[3-j]);
                break;
            }
        }
    }
}
