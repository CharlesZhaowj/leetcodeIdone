package autumn.tencent;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
/**
 * 妈耶居然直接就过了...太秀了Orz...
 * 3
 * 91 16 5
 * 58 16 0
 * 96 12 4
 */
public class NiuNiuNanTi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while(num-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            boolean flag = false;
            for(int i = 1; i < 100; i++) {
                if((a * i) % b == c) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
