package autumn.tencent;

import java.util.Scanner;

/**
 * 模拟只能过%20，估计还是得用数学的方法。
 * 没错，用素数筛
 */
public class ZuiXiaoGongBeiShu {
    public static int getGcd(int n1, int n2) {
        int ans = 0;
        if (n1 < n2) {
            // swap if the first one is smaller than second one.
            int temp = n2;
            n2 = n1;
            n1 = temp;
        }
        if (n1 % n2 == 0) {
            ans = n2;
        }
        while (n1 % n2 > 0) {
            n1 = n1 % n2;
            if (n1 < n2) {
                int temp = n2;
                n2 = n1;
                n1 = temp;
            }
            if (n1 % n2 == 0) {
                ans = n2;
            }
        }
        return ans;
    }

    public static int getLcm(int n1, int n2) {
        return n1 / getGcd(n1, n2) * n2 ;
    }

    public static int getLcm(int[] A, int length) {
        if(A.length == 0) {
            return 0;
        }
        int ans = 1;
        for(int i = 1; i <= length; i++) {
            ans = getLcm(ans, A[i]);
        }
        return ans;
    }

    public static int getSmoothLcm(int start, int end) {
        int ans = start;
        for(int i = start+1; i <= end; i++) {
            ans = getLcm(ans, i);
        }
        return ans;
    }

    public static void main(String[] args) {
        /*
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int[] A = new int[1000000];
        for(int i = 1; i <= n; i++) {
            A[i] = i;
        }
        int firstLcm = getLcm(A, n);
        int[] LcmDP = new int[1000000];
        LcmDP[0] = firstLcm;
        int[] LcmDP2 = new int[1000000];
        LcmDP2[0] = 1;
        int ansM = 0;
        for(int i = 1; i < LcmDP.length; i++) {
            int cur = n+i;
            LcmDP[i] = getLcm(LcmDP[i-1], cur);
            LcmDP2[i] = getLcm(LcmDP2[i-1], cur);
            if(LcmDP[i] == LcmDP2[i]) {
                ansM = n+i;
                break;
            }
        }
        System.out.println(ansM);
        */



        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int firstLcm = getSmoothLcm(1, n);
        System.out.println(firstLcm);
    }
}

/**
 * 别人的参考答案
 */
/*
import java.math.BigInteger;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        System.out.println(LCM(n));
    }

    public static BigInteger LCM(int n) {
    	BigInteger ans = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            int tmp = 1;
            if (issushu(i)) {
                while (tmp * i <= n) {
                    tmp *= i;
                }
            }
            ans = ans.multiply(BigInteger.valueOf(tmp));
        }
        return ans;
    }

    public static boolean issushu(int n) {
        if (n == 2 || n == 1)
			return true;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
    }
}
 */