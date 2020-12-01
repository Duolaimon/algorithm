/**
 * Leetcode - find_all_anagrams_in_a_string
 */
package com.duol.leetcode.y20.before.find_all_anagrams_in_a_string;

import java.util.*;

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

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] pNum = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pNum[p.charAt(i) - 'a']++;
        }
        int[] sNum = new int[26];
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            if (length == p.length()) {
                sNum[s.charAt(i - p.length()) - 'a']--;
                length--;
            }
            sNum[s.charAt(i) - 'a']++;
            length++;
            if (Arrays.equals(pNum, sNum)) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }

}
