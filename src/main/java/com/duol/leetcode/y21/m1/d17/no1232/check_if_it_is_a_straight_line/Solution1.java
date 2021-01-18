/**
 * Leetcode - check_if_it_is_a_straight_line
 */
package com.duol.leetcode.y21.m1.d17.no1232.check_if_it_is_a_straight_line;

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

    public boolean checkStraightLine(int[][] coordinates) {
        int[] s1 = coordinates[0];
        int[] s2 = coordinates[1];
        double slope = getSlope(s1, s2);
        for (int i = 2; i < coordinates.length; i++) {
            int[] s = coordinates[i];
            double curSlope = getSlope(s1, s);
            if (curSlope != slope) {
                return false;
            }
        }
        return true;
    }

    private double getSlope(int[] s1, int[] s2) {
        double slope = 1;
        if (s2[1] - s1[1] != 0)
            slope = (double) (s2[0] - s1[0]) / (double) (s2[1] - s1[1]);
        return slope;
    }
}
