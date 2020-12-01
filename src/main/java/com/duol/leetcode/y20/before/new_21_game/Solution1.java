/**
 * Leetcode - new_21_game
 */
package com.duol.leetcode.y20.before.new_21_game;

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

    public double new21Game(int N, int K, int W) {
        double[] dp = new double[K + W];
        double sum = 0.0D;
        for (int i = K; i < K + W; i++) {
            dp[i] = (i <= N ? 1.0D : 0.0D);
            sum += dp[i];
        }
        for (int i = K - 1; i > -1; i--) {
            dp[i] = sum / W;
            sum = sum - dp[i + W] + dp[i];
        }
        return dp[0];
    }

}
