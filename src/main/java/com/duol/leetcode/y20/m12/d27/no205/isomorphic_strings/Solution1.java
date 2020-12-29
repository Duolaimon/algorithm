/**
 * Leetcode - isomorphic_strings
 */
package com.duol.leetcode.y20.m12.d27.no205.isomorphic_strings;

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

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> hasT = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char sC = s.charAt(i);
            char tC = t.charAt(i);
            if (map.containsKey(sC)) {
                Character mapC = map.get(sC);
                if (!Objects.equals(mapC, tC)) {
                    return false;
                }
            } else {
                map.put(sC, tC);
                if (hasT.contains(tC)) {
                    return false;
                } else {
                    hasT.add(tC);
                }
            }
        }
        return true;
    }

}
