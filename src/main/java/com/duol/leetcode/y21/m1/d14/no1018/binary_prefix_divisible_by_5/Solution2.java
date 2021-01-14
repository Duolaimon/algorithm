/**
 * Leetcode - binary_prefix_divisible_by_5
 */
package com.duol.leetcode.y21.m1.d14.no1018.binary_prefix_divisible_by_5;

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

    public List<Boolean> prefixesDivBy5(int[] A) {
        Boolean[] ans = new Boolean[A.length];
        Arrays.fill(ans, false);
        int x = 0;
        for (int i = 0; i < A.length; i++) {
            x = 2 * x + A[i];
            x = x % 5;
            if (x == 0) ans[i] = true;
        }
        return Arrays.asList(ans);
    }

}
