/**
 * Leetcode - russian_doll_envelopes
 */
package com.duol.leetcode.y21.m3.d4.no354.russian_doll_envelopes;

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

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (c1, c2) -> {
            if (c1[0] == c2[0]) {
                return c1[1] - c2[1];
            }
            return c1[0] - c2[0];
        });
        int[] re = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            re[i] = 1;
        }
        int ans = 1;
        for (int i = 1; i < envelopes.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    re[i] = Math.max(re[i], re[j] + 1);
                }
            }
            ans = Math.max(ans, re[i]);
        }
        return ans;

    }

}
