/**
 * Leetcode - hamming_distance
 */
package com.duol.leetcode.y20.before.hamming_distance;

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

    public int hammingDistance(int x, int y) {
        int t = x ^ y;
        int result = 0;
        while (t > 0) {
            if ((t & 1) > 0) {
                result++;
            }
            t >>= 1;
        }
        return result;
    }

}
