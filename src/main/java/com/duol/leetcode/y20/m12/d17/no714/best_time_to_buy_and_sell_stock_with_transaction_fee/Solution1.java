/**
 * Leetcode - best_time_to_buy_and_sell_stock_with_transaction_fee
 */
package com.duol.leetcode.y20.m12.d17.no714.best_time_to_buy_and_sell_stock_with_transaction_fee;
import java.util.*;
import com.duol.common.*;

/** 
 * 一般的动态规划题目思路三步走：
 *
 * 定义状态转移方程
 * 给定转移方程初始值
 * 写代码递推实现转移方程
 * 1. 定义状态转移方程
 * 定义二维数组 dp[n][2]：
 *
 * dp[i][0] 表示第 i 天不持有可获得的最大利润；
 * dp[i][1] 表示第 i 天持有可获得的最大利润（注意是第 ii 天持有，而不是第 ii 天买入）。
 * 定义状态转移方程：
 *
 * 不持有：dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee)
 *
 * 对于今天不持有，可以从两个状态转移过来：1. 昨天也不持有；2. 昨天持有，今天卖出。两者取较大值。
 *
 * 持有：dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i])
 *
 * 对于今天持有，可以从两个状态转移过来：1. 昨天也持有；2. 昨天不持有，今天买入。两者取较大值。
 *
 * 2. 给定转移方程初始值
 * 对于第 00 天：
 *
 * 不持有： dp[0][0] = 0
 * 持有（即花了 price[0] 的钱买入）： dp[0][1] = -prices[0]
 *
 * 空间优化：转移的时候，dp[i]dp[i] 只会从 dp[i-1]dp[i−1] 转移得来，因此第一维可以去掉：
 *
 * 作者：sweetiee
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/jian-dan-dpmiao-dong-gu-piao-mai-mai-by-tejdo/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 
 */
class Solution1 implements Solution {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = -prices[0];
        for (int i = 1; i < n; i++) {
            int tmp = dp[0];
            dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
            dp[1] = Math.max(dp[1], tmp - prices[i]);
        }
        return dp[0];
    }

}
