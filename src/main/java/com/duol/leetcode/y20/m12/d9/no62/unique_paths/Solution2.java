/**
 * Leetcode - unique_paths
 */
package com.duol.leetcode.y20.m12.d9.no62.unique_paths;

import java.util.*;

import com.duol.common.*;

/**
 *
 */
class Solution2 implements Solution {

    public int uniquePaths(int m, int n) {
        int[] dp = new int[m];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                dp[i] = (i == 0 || j == 0) ? 1 : dp[i - 1] + dp[i];
            }
        }
        return dp[m - 1];
    }

}
