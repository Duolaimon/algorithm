/**
 * Leetcode - edit.distance
 */
package com.duol.leetcode.edit.distance;

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

    int[][] dp;

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < m; j++) {
            dp[0][j] = j;
        }
        return minDistance(word1, word2, n, m);
    }

    private int minDistance(String s1, String s2, int l1, int l2) {
        if (l1 == 0) return l2;
        if (l2 == 0) return l1;
        if (dp[l1][l2] > 0) return dp[l1][l2];
        int ans;
        if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
            ans = minDistance(s1, s2, l1 - 1, l2 - 1);
        } else {
            ans = Math.min(minDistance(s1, s2, l1 - 1, l2 - 1)
                    , Math.min(minDistance(s1, s2, l1 - 1, l2)
                            , minDistance(s1, s2, l1, l2 - 1))) + 1;
        }
        return dp[l1][l2] = ans;
    }

}
