/**
 * Leetcode - climbing_stairs
 */
package com.duol.leetcode.y20.before.climbing_stairs;

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

    public int climbStairs(int n){
        if (n == 0) {
            return 0;
        }
        int l = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            int swap = r;
            r = l + r;
            l = swap;
        }
        return r;
    }

}
