package com.pickbucket.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class P_762_primeNumberOfSetBitsInBinaryRepresentation {

    static Set<Integer> primeSet = new HashSet();

    public int countPrimeSetBits(int left, int right) {
        int ansCnt = 0;
        for (int i = left; i <= right; i++) {
            if (isPrime(getBit(i))) {
                ansCnt++;
            }
        }
        return ansCnt;
    }

    public int getBit(int i) {
        int bitCnt = 0;
        while(i > 0) {
            if ((i & -i) == 1) {
                bitCnt++;
            }
            i = i >> 1;
        }
        return bitCnt;
    }

    public boolean isPrime(int i) {
        if (primeSet.contains(i)) {
            return true;
        } else if (i == 1 || i == 2) {
            return true;
        } else {
            int sqrt = (int)Math.sqrt(i) + 1;
            for (int j = 2; j <= sqrt; j++) {
                if (i % j == 0) {
                    return false;
                }
            }
        }
        primeSet.add(i);
        return true;
    }


    public static void main(String[] args) {
//        new P_762_primeNumberOfSetBitsInBinaryRepresentation().countPrimeSetBits(6, 10);
        System.out.println(Math.sqrt(7));
        System.out.println(((int)Math.sqrt(7)));
    }
}
