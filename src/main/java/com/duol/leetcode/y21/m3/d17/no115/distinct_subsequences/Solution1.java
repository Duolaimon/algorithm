/**
 * Leetcode - distinct_subsequences
 */
package com.duol.leetcode.y21.m3.d17.no115.distinct_subsequences;

import java.util.*;

import com.duol.common.*;

/**
 * 递归超时
 */
class Solution1 implements Solution {

    public int numDistinct(String s, String t) {

        return numDistinct(s, t, 0, s.length(), 0, t.length());
    }

    private int numDistinct(String s, String t, int s1, int s2, int t1, int t2) {
        if (s2 - s1 < t2 - t1) {
            return 0;
        }
        int res = 0;
        while (s1 < s2) {
            if (s.charAt(s1) == t.charAt(t1)) {
                if (t1 == t2 - 1) {
                    res++;
                } else {
                    res += numDistinct(s, t, s1 + 1, s2, t1 + 1, t2);
                }
            }
            s1++;
        }
        return res;
    }

}
