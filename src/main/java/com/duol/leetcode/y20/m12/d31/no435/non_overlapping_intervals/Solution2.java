/**
 * Leetcode - non_overlapping_intervals
 */
package com.duol.leetcode.y20.m12.d31.no435.non_overlapping_intervals;

import java.util.*;

import com.duol.common.*;

/**
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution2 implements Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        int cnt = 0;
        int i = 0;
        int j = 1;
        while (j < intervals.length) {
            if (intervals[i][1] <= intervals[j][0]) {
                i = j;
                j++;
            } else {
                if (intervals[i][1] < intervals[j][1]) {
                    cnt++;
                    j++;
                } else {
                    cnt++;
                    i = j;
                    j++;
                }
            }
        }

        return cnt;
    }

}
