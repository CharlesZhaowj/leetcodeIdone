package com.pickbucket.leetcode.dynamicprogram;

public class UglyNumber {
    /**
     * can't work in this scene, too much calculation
     * @param n
     * @return
     */
    public int nthUglyNumberBySimulation(int n) {
        int cnt = 0;
        int curNum = 0;
        while (cnt != n && cnt < 90000000) {
            if (isUglyNum(++curNum)) {
                cnt++;
            }
        }
        return curNum;
    }

    public boolean isUglyNum(int n) {
        while(n % 2 == 0) {
            n /= 2;
        }
        while(n % 5 == 0) {
            n /= 5;
        }
        while(n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
//        System.out.println(new UglyNumber().nthUglyNumberBySimulation(10));


    }
}
