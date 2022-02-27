package com.pickbucket.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P_638_shoppingOffers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        return helper(price, special, needs, needs.size(), map);
    }

    public int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int size,
                      HashMap<List<Integer>, Integer> map) {
        if(map.get(needs) != null) {
            return map.get(needs);
        }
        int minPrice = 0;
        // 不用套餐
        for(int i = 0; i < size; i++) {
            minPrice += (needs.get(i) * price.get(i));
        }
        // 使用套餐
        for(List<Integer> taocan : special) {
            boolean canUseThis = true;
            int thisPrice = 0;
            for(int i = 0; i < size; i++) {
                if(needs.get(i) < taocan.get(i)) { // 套餐容量过大
                    canUseThis = false;
                    break;
                }
            }
            if(canUseThis) {
                List<Integer> needsClone = new ArrayList<>(needs);
                for(int i = 0; i < size; i++) {
                    needsClone.set(i, needsClone.get(i) - taocan.get(i));
                }
                thisPrice = taocan.get(size) +  helper(price, special, needsClone, size, map);
                if(thisPrice < minPrice) {
                    minPrice = thisPrice;
                }
            }
        }
        map.put(needs, minPrice);
        return minPrice;
    }
}
