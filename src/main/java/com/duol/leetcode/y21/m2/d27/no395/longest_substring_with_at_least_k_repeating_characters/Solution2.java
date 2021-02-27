/**
 * Leetcode - longest_substring_with_at_least_k_repeating_characters
 */
package com.duol.leetcode.y21.m2.d27.no395.longest_substring_with_at_least_k_repeating_characters;
import java.util.*;
import com.duol.common.*;

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

    public int longestSubstring(String s, int k){
        if (k == 1)
            return s.length();
        if (s.length() < k)
            return 0;
        return longestSubstring(s, 0, s.length() - 1, k);

    }

    int longestSubstring(String str, int start, int end, int k) {
        if (start >= end || end - start + 1 < k)
            return 0;
        int[] count = new int[26];
        for (int i = start; i <= end; i++) {
            ++count[str.charAt(i) - 'a'];
        }

        boolean needSplit = false;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0 && count[i] < k) {
                needSplit = true;
                break;
            }
        }
        if (!needSplit)
            return end - start + 1;

        int ret = 0;
        int left = start, right = start;
        while (right <= end) {
            while (left <= end) {
                if (count[str.charAt(left) - 'a'] >= k)
                    break;
                ++left;
            }
            right = left + 1;

            while (right <= end) {
                if (count[str.charAt(right) - 'a'] > 0 && count[str.charAt(right) - 'a'] < k)
                    break;
                ++right;
            }

            if (right - left > ret)
                ret = Math.max(ret, longestSubstring(str, left, right - 1, k));

            left = right + 1;
        }
        return ret;
    }

}
