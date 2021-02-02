/**
 * Leetcode - longest_repeating_character_replacement
 */
package com.duol.leetcode.y21.m2.d2.no424.longest_repeating_character_replacement;
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

    public int characterReplacement(String s, int k) {
        int[] num = new int[26];
        int n = s.length();
        int maxn = 0;
        int left = 0, right = 0;
        while (right < n) {
            int v = s.charAt(right) - 'A';
            num[v]++;
            maxn = Math.max(maxn, num[v]);
            while (right - left + 1 > k + maxn) {
                num[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }

}
