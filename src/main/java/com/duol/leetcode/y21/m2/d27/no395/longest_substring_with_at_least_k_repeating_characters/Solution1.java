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
class Solution1 implements Solution {

    public int longestSubstring(String s, int k) {
        int ret = 0;
        int n = s.length();
        for (int t = 1; t <= 26; t++) {
            int l = 0, r = 0;
            int[] cnt = new int[26];
            int tot = 0;
            int less = 0;
            while (r < n) {
                int rNum = s.charAt(r) - 'a';
                cnt[rNum]++;
                if (cnt[rNum] == 1) {
                    tot++;
                    less++;
                }
                if (cnt[rNum] == k) {
                    less--;
                }

                while (tot > t) {
                    int lNum = s.charAt(l) - 'a';
                    cnt[lNum]--;
                    if (cnt[lNum] == k - 1) {
                        less++;
                    }
                    if (cnt[lNum] == 0) {
                        tot--;
                        less--;
                    }
                    l++;
                }
                if (less == 0) {
                    ret = Math.max(ret, r - l + 1);
                }
                r++;
            }
        }
        return ret;
    }

}
