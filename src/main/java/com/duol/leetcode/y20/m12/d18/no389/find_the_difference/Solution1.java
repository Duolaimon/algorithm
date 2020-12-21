/**
 * Leetcode - find_the_difference
 */
package com.duol.leetcode.y20.m12.d18.no389.find_the_difference;
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

    public char findTheDifference(String s, String t){
        int[] sArray = new int[26];
        int[] tArray = new int[26];
        for (char c : s.toCharArray()) {
            sArray[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            tArray[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sArray[i] != tArray[i]) {
                return (char) ('a' + i);
            }
        }
        return ' ';
    }

}
