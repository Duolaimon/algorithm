/**
 * Leetcode - best_time_to_buy_and_sell_stock_iii
 */
package com.duol.leetcode.y21.m1.d9.no123.best_time_to_buy_and_sell_stock_iii;

import java.util.*;

import com.duol.common.*;

/**
 * 作者：mantoufan
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/di-gui-dong-tai-gui-hua-tan-xin-er-fen-4-xxd5/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution2 implements Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length, i = 0, min = prices[0], max = prices[n - 1];
        int[] dp0 = new int[n];
        int dp1 = 0, r = 0, t;
        while (++i < n) {
            if ((t = prices[i] - min) < 0) {
                min = prices[i];
            } else {
                dp0[i] = t;
            }
        }
        while (i-- > 1) {
            if ((t = max - prices[i]) < 0) {
                max = prices[i];
            } else if (t > dp1) {
                dp1 = t;
            }

            if ((t = dp0[i] + dp1) > r) {
                r = t;
            }
        }
        return r;


    }

}
