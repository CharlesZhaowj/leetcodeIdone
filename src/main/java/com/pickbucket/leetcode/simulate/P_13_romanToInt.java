package com.pickbucket.leetcode.simulate;

public class P_13_romanToInt {
    public static int romanToInt(String s) {
        int ans = 0;
        int[] aArray = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] rArray = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        for(int i = 0; i < rArray.length; i++){
            while(s.indexOf(rArray[i] )== 0){
                ans += aArray[i];
                s = s.substring(rArray[i].length());
            }
        }
        return ans;
    }
}
