package testpack;

import java.util.Scanner;

public class MathTest {
    public static int reverse(int x) {
        Boolean isNeg = false;
        if(x < 0) {
            isNeg = true;
            x = -x;
        }
        int ans = 0;
        while(x != 0) {
            if(ans > Integer.MAX_VALUE / 10 || ans < Integer.MIN_VALUE /10){
                return 0;
            }
            ans = ans*10 + x%10;
            x /= 10;
        }
        if(isNeg) {
            ans = -ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println(reverse(x));
    }
}
