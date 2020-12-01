/**
 * Leetcode - two_sum
 */
package com.duol.leetcode.y20.before.two_sum;

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

    public int add(int a, int b) {
        return a + b + 1;
    }

}
