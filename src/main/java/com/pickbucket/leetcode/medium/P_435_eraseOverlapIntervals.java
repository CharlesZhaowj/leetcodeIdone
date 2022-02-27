package com.pickbucket.leetcode.medium;

import com.pickbucket.leetcode.common.Interval;

import java.util.Arrays;
import java.util.Comparator;


public class P_435_eraseOverlapIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o.end));
        int cnt = 1;
        int end = intervals[0].end;
        for (Interval interval : intervals) {
            if (interval.start < end) {
                continue;
            }
            end = interval.end;
            cnt++;
        }
        return intervals.length - cnt;
    }
}
