/**
 * Leetcode - counting_bits
 */
package com.duol.leetcode.y20.before.counting_bits;

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

    public int[] countBits(int num){
        int[] result = new int[num + 1];
        if (num >= 0) {
            result[0] = 0;
        }
        if (num >= 1) {
            result[1] = 1;
        }
        if (num >= 2) {
            result[2] = 1;
        }
        for (int i = 3; i <= num; i++) {
            if (i % 2 == 1) {
                result[i] = result[i - 1] + 1;
                continue;
            }
            int p = i;
            while (p % 2 == 0) {
                p >>= 1;
            }
            result[i] = result[p];
        }
        return result;
    }

}
