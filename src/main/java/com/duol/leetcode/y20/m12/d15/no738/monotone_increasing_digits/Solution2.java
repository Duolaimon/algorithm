/**
 * Leetcode - monotone_increasing_digits
 */
package com.duol.leetcode.y20.m12.d15.no738.monotone_increasing_digits;

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

    public int monotoneIncreasingDigits(int N) {
        int rs = 0, exp = 1, p = 10;
        while (N > 0) {
            int t = N % 10;
            if (t <= p) {
                rs += t * exp;
                p = t;
            } else {
                rs = t * exp - 1;
                p = t - 1;
            }
            N /= 10;
            exp *= 10;
        }
        return rs;
    }

}
