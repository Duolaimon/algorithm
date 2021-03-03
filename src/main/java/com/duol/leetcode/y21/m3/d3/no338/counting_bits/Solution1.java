/**
 * Leetcode - counting_bits
 */
package com.duol.leetcode.y21.m3.d3.no338.counting_bits;

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

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        if (num == 0) {
            return res;
        }
        res[1] = 1;
        for (int i = 2; i <= num; i++) {
            res[i] = (i & 1) + res[i >> 1];
        }
        return res;
    }

}
