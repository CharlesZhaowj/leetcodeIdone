package leetcode;

import java.util.Arrays;
import java.util.Comparator;

class Interval {
    int start;
    int end;
}

public class P_435 {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o.end));
        int cnt = 1;
        int end = intervals[0].end;
        for(int i = 0; i < intervals.length; i++) {
            if(intervals[i].start < end) {
                continue;
            }
            end = intervals[i].end;
            cnt++;
        }
        return intervals.length - cnt;
    }
}
