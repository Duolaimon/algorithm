/**
 * Leetcode - longest_palindrome
 */
package com.duol.leetcode.longest_palindrome;

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

    public int longestPalindrome(String s) {
        int[] lower = new int[26];
        int[] upper = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                lower[c - 'a'] += 1;
            } else if (c >= 'A' && c <= 'Z') {
                upper[c - 'A'] += 1;
            }
        }
        int length = 0;
        boolean hasOne = false;
        for (int i = 0; i < 26; i++) {
            if (lower[i] % 2 == 0) {
                length += lower[i];
            } else {
                if (lower[i] > 2) {
                    length += lower[i] - 1;
                }
                hasOne = true;
            }
            if (upper[i] % 2 == 0) {
                length += upper[i];
            } else {
                if (upper[i] > 2) {
                    length += upper[i] - 1;
                }
                hasOne = true;
            }
        }
        return length + (hasOne ? 1 : 0);
    }

}
