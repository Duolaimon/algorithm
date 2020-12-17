/**
 * Leetcode - best_time_to_buy_and_sell_stock_with_transaction_fee
 */
package com.duol.leetcode.y20.m12.d17.no714.best_time_to_buy_and_sell_stock_with_transaction_fee;

import java.util.*;

import com.duol.common.*;

/**
 */
class Solution2 implements Solution {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int buy = prices[0] + fee;
        int profit = 0;
        for (int i = 1; i < n; ++i) {
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
            } else if (prices[i] > buy) {
                profit += prices[i] - buy;
                buy = prices[i];
            }
        }
        return profit;
    }

}
