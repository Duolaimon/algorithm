/**
 * Leetcode - next_greater_element
 */
package com.duol.leetcode.y20.before.next_greater_element;

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

    public int[] nextGreaterElement(int[] para1, int[] para2) {
        int[] result = new int[para1.length];
        if (para1.length == 0) {
            return result;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int p : para2) {
            if (p > max) {
                max = p;
            }
            if (p < min) {
                min = p;
            }
        }
        int[] index = new int[max - min + 2];
        int last = para2[para2.length - 1];
        index[last - min] = -1;
        for (int i = para2.length - 2; i >= 0; i--) {
            int current = para2[i];
            int next = para2[i + 1];
            while (current > next && next != -1) {
                next = index[next - min];
            }
            index[current - min] = next;
        }
        for (int i = 0; i < para1.length; i++) {
            result[i] = index[para1[i] - min];
        }
        return result;
    }

}
