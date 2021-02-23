/**
 * Leetcode - grumpy_bookstore_owner
 */
package com.duol.leetcode.y21.m2.d23.no1052.grumpy_bookstore_owner;

import java.util.*;

import com.duol.common.*;

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

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int res = 0;
        int len = customers.length;
        int left = 0, right = 0;
        int max = 0;
        int cur = 0;
        while (right < len) {
            if (grumpy[right] == 0) {
                res += customers[right];
                customers[right] = 0;
            }
            cur += customers[right];
            if (right - left + 1 == X){
                max = Math.max(max, cur);
                cur -= customers[left++];
            }
            right++;
        }
        return res + max;
    }

}
