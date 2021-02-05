/**
 * Leetcode - get_equal_substrings_within_budget
 */
package com.duol.leetcode.y21.m2.d5.no1208.get_equal_substrings_within_budget;

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

    public int equalSubstring(String s, String t, int maxCost) {
        int length = s.length();
        int[] subArray = new int[length];
        for (int i = 0; i < length; i++) {
            subArray[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int res = 0;
        int left = 0, right = 0;
        int cost = 0;
        while (right < length) {
            cost += subArray[right];
            while (cost > maxCost) {
                cost -= subArray[left];
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

}
