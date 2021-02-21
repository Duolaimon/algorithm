/**
 * Leetcode - longest_continuous_subarray_with_absolute_diff_less_than_or_equal_to_limit
 */
package com.duol.leetcode.y21.m2.d21.no1438.longest_continuous_subarray_with_absolute_diff_less_than_or_equal_to_limit;
import java.util.*;
import com.duol.common.*;

/** 
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution1 implements Solution {

    public int longestSubarray(int[] nums, int limit) {
        int l = 0, r = 0, len = nums.length, minL = 0, minR = -1, maxL = len, maxR = len - 1, res = 0;
        int[] ascending = new int[len];
        while (r < len) {
            int n = nums[r];
            while (minR >= minL && n < ascending[minR]) minR--;
            while (maxR >= maxL && n > ascending[maxL]) maxL++;
            ascending[++minR] = ascending[--maxL] = n;
            while (ascending[maxR] - ascending[minL] > limit) {
                if (nums[l] == ascending[minL]) minL++;
                if (nums[l] == ascending[maxR]) maxR--;
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }

}
