/**
 * Leetcode - word_pattern
 */
package com.duol.leetcode.y20.m12.d16.no290.word_pattern;
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

    public boolean wordPattern(String pattern, String s){
        String[] oriStrings = s.split(" ");
        if (oriStrings.length != pattern.length()) {
            return false;
        }
        String[] patternStr = new String[26];
        for (int i = 0; i < 26; i++) {
            patternStr[i] = "";
        }
        Set<String> beOccupied = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            int index = pattern.charAt(i) - 'a';
            if (patternStr[index].equals("")) {
                if (beOccupied.contains(oriStrings[i])) {
                    return false;
                }
                patternStr[index] = oriStrings[i];
                beOccupied.add(oriStrings[i]);
            }
        }
        String[] newStrings = new String[oriStrings.length];
        for (int i = 0; i < pattern.length(); i++) {
            newStrings[i] = patternStr[pattern.charAt(i) - 'a'];
        }
        return Arrays.equals(oriStrings, newStrings);
    }

}
