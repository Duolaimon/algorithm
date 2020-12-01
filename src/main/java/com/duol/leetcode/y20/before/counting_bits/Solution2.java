/**
 * Leetcode - counting_bits
 */
package com.duol.leetcode.y20.before.counting_bits;

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

    public int[] countBits(int num) {
        if (num <= 0) {
            return new int[1];
        }
        int[] res = new int[num + 1];
        for (int i = 0; i < num + 1; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

}
