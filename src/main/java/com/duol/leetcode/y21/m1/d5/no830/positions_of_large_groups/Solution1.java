/**
 * Leetcode - positions_of_large_groups
 */
package com.duol.leetcode.y21.m1.d5.no830.positions_of_large_groups;

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

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int left = 0;
        char c = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur != c) {
                if (i - left >= 3) {
                    List<Integer> re = new ArrayList<>();
                    re.add(left);
                    re.add(i - 1);
                    result.add(re);
                }
                left = i;
                c = cur;
            }
        }
        if (s.length() - left >= 3) {
            List<Integer> re = new ArrayList<>();
            re.add(left);
            re.add(s.length() - 1);
            result.add(re);
        }
        return result;
    }

}
