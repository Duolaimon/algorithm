/**
 * Leetcode - summary_ranges
 */
package com.duol.leetcode.y21.m1.d10.no228.summary_ranges;

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
class Solution1 implements Solution {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == max + 1) {
                max++;
            } else {
                res.add(genRange(min, max));
                min = max = nums[i];
            }
        }
        res.add(genRange(min, max));
        return res;
    }

    private String genRange(int min, int max) {
        if (min == max) {
            return String.format("%d", min);
        }
        return String.format("%d->%d", min, max);
    }

}
