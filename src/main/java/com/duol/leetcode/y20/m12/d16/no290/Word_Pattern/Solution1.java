/**
 * Leetcode - word_pattern
 */
package com.duol.leetcode.y20.m12.d16.no290.word_pattern;

import java.util.*;

import com.duol.common.*;

/**
 *
 */
class Solution1 implements Solution {

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> beOccupied = new HashSet<>();
        String[] strings = s.split(" ");
        if (strings.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                String cur = map.get(c);
                if (!Objects.equals(cur, strings[i])) {
                    return false;
                }
            } else {
                if (beOccupied.contains(strings[i])) {
                    // 被其他对应关系占用
                    return false;
                }
                map.put(c, strings[i]);
                beOccupied.add(strings[i]);
            }
        }
        return true;
    }

}
