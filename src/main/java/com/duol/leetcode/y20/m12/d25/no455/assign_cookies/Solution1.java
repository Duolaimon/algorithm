/**
 * Leetcode - assign_cookies
 */
package com.duol.leetcode.y20.m12.d25.no455.assign_cookies;

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

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int sum = 0;
        for (int sIndex = 0, gIndex = 0; gIndex < g.length && sIndex < s.length; sIndex++) {
            if (s[sIndex] >= g[gIndex]) {
                sum++;
                gIndex++;
            }
        }
        return sum;
    }

}
