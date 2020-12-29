/**
 * Leetcode - best_time_to_buy_and_sell_stock_iv
 */
package com.duol.leetcode.y20.m12.d28.no188.best_time_to_buy_and_sell_stock_iv;

import java.util.*;

import com.duol.common.*;

/**
 * [2,4,1,12,43,11,4,5,10,6,29,10,2] 67
 * [0,2,-3,11,31,-32,-7,1,5,-4,23,-19,-8]
 */
class Solution1 implements Solution {

    public int maxProfit(int k, int[] prices) {
        if (k > prices.length / 2) {
            return maxProfitNormal(prices);
        }
        //第i次交易后持有/不持有的金额
        int[][] dp = new int[k + 1][2];
        for (int i = 0; i <= k; i++) {
            dp[i][1] = Integer.MIN_VALUE;
        }
        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
//                dp[i][1] = Math.max(dp[i - 1][0] - price, dp[i][1]);
//                dp[i][0] = Math.max(dp[i][0], dp[i][1] + price);
                if (dp[i][1] < dp[i - 1][0] - price) {
                    //如果当前持有
                    dp[i][1] = dp[i - 1][0] - price;
                }
                if (dp[i][0] < dp[i][1] + price) {
                    dp[i][0] = dp[i][1] + price;
                }
            }
        }
        return dp[k][0];
    }

    private int maxProfitNormal(int[] prices) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }
        int notHold = 0;
        int hold = -prices[0];

        for (int i = 1; i < length; i++) {
            int price = prices[i];
//            donTHold = Math.max(hold + price, donTHold);
//            hold = Math.max(donTHold - price, hold);

            if (hold < notHold - price) {
                hold = notHold - price;
            }
            if (notHold < hold + price) {
                notHold = hold + price;
            }
        }
        return notHold;
    }

}
