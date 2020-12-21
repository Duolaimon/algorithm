/**
 * Leetcode - min_cost_climbing_stairs
 */
package com.duol.leetcode.y20.m12.d21.no746.min_cost_climbing_stairs;

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

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int first = 0;
        int second = 0;
        for (int i = 2; i <= n; i++) {
            int temp = first;
            first = second;
            second = Math.min(first + cost[i - 1], temp + cost[i - 2]);
        }
        return second;
    }

}
