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
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution1 implements Solution {

    public int characterReplacement(String s, int k) {
        if (s.length() == 0) {
            return 0;
        }
        int res = 0;
        int i = 1;
        int curLength = 1;
        char curChar = s.charAt(0);
        int t = k;
        int diff = 0;
        while (i < s.length()) {
            if (s.charAt(i) == curChar) {
                curLength++;
                i++;
            } else {
                if (t == 0) {
                    // 重置
                    res = Math.max(res, curLength);
                    if (s.charAt(diff) == curChar) {
                        diff = i;
                    } else {
                        i = diff;
                    }
                    curChar = s.charAt(diff);
                    i++;
                    t = k;
                    curLength = 1;
                } else {
                    t--;
                    curLength++;
                    if (s.charAt(diff) == curChar) {
                        diff = i;
                    }
                    i++;
                }
            }
        }
        return Math.max(res, curLength + Math.min(s.length() - curLength, t));
    }

}
