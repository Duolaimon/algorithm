/**
 * Leetcode - longest_common_prefix
 */
package com.duol.leetcode.longest_common_prefix;

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

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String commont = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < strs[i].length() && j < commont.length() && commont.charAt(j) == strs[i].charAt(j); j++) {
            }
            commont = strs[i].substring(0, j);
            if (commont.isEmpty()) {
                return "";
            }
        }
        return commont;
    }

}
