/**
 * Leetcode - hamming_distance
 */
package com.duol.leetcode.hamming_distance;

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

    public int hammingDistance(int x, int y) {
        int t = x ^ y, result = 0;
        while (t > 0) {
            result++;
            t &= t - 1;
        }
        return result;
    }

}
