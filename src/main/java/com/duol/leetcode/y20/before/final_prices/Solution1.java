/**
 * Leetcode - final_prices
 */
package com.duol.leetcode.y20.before.final_prices;
import java.util.*;

/** 
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution1 implements Solution {

    public int[] finalPrices(int[] prices){
        int[] result = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int index = 1;
        while (!stack.isEmpty() && index < prices.length) {
            while (!stack.isEmpty() && prices[index] <= prices[stack.peek()]) {
                Integer t = stack.pop();
                result[t] = prices[t] - prices[index];
            }
            stack.push(index++);
        }
        while (!stack.isEmpty()) {
            Integer t = stack.pop();
            result[t] = prices[t];
        }
        return result;
    }

}
