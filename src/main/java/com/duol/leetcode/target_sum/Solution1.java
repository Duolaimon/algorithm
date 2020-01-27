/**
 * Leetcode - target_sum
 */
package com.duol.leetcode.target_sum;

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

    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums, S, nums.length - 1);
    }

    private int findTargetSumWays(int[] nums, int S, int end) {
        int r = 0;
        if (end == 0) {
            if (S == nums[end]) {
                r += 1;
            }
            if (S == -nums[end]) {
                r += 1;
            }
            return r;
        }
        int c = nums[end];
        r = findTargetSumWays(nums, S - c, end - 1) + findTargetSumWays(nums, S + c, end - 1);
        return r;
    }

}
