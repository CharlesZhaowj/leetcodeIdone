package com.pickbucket.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class P_1710_maximumUnits {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // greedy
        int curSize = 0;
        Set<Integer> valueSet = new HashSet<>();
        int totalbox = 0;
        while (totalbox < truckSize && valueSet.size() < boxTypes.length) {
            int max = 0;
            int maxVal = 0;
            for (int i = 0; i < boxTypes.length; i++) {
                if (!valueSet.contains(i) && boxTypes[i][1] > maxVal) {
                    max = i;
                    maxVal = boxTypes[i][1];
                }
            }
            valueSet.add(max);
            if (totalbox + boxTypes[max][0] >= truckSize) {
                curSize += boxTypes[max][1] * (truckSize - totalbox);
                totalbox = truckSize;
            } else {
                curSize += boxTypes[max][1] * boxTypes[max][0];
                totalbox += boxTypes[max][0];
            }
        }
        return curSize;
    }

    public static void main(String[] args) {
        P_1710_maximumUnits invoker = new P_1710_maximumUnits();
//        invoker.maximumUnits(new int[][]{{1,3},{2,2},{3,1}}, 4);
        invoker.maximumUnits(new int[][]{{2,1}, {4,4}, {3,1}, {4,1}, {2,4}, {3,4}, {1,3}, {4,3}, {5,3}, {5,3}}, 13);
    }
}
