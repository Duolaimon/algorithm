/**
 * Leetcode - best_time_to_buy_and_sell_stock_iii
 */
package com.duol.leetcode.y21.m1.d9.no123.best_time_to_buy_and_sell_stock_iii;

import java.util.*;

import com.duol.common.*;

/**
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-iii-by-wrnt/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution1 implements Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            // 在第 i 天我们可以不进行任何操作，保持不变，也可以在未进行任何操作的前提下以 prices[i] 的价格买入股票
            buy1 = Math.max(buy1, -prices[i]);
            // 在第 i 天我们可以不进行任何操作，保持不变，也可以在只进行过一次买操作的前提下以 prices[i] 的价格卖出股票
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;

    }

}
