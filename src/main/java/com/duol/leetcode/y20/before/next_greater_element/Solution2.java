/**
 * Leetcode - next_greater_element
 */
package com.duol.leetcode.y20.before.next_greater_element;
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
class Solution2 implements Solution {

    public int[] nextGreaterElement(int[] para1, int[] para2){
        int[] result = new int[para1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>(para2.length);
        for (int p : para2) {
            while (!stack.isEmpty() && p > stack.peek()) {
                map.put(stack.pop(), p);
            }
            stack.push(p);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        for (int i = 0; i < para1.length; i++) {
            result[i] = map.get(para1[i]);
        }
        return result;
    }

}
