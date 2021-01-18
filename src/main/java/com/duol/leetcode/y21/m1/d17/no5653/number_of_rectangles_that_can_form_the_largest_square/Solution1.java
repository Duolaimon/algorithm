/**
 * Leetcode - number_of_rectangles_that_can_form_the_largest_square
 */
package com.duol.leetcode.y21.m1.d17.no5653.number_of_rectangles_that_can_form_the_largest_square;

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

    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0;
        int size = 0;
        for (int[] rectangle : rectangles) {
            int min = Math.min(rectangle[0], rectangle[1]);
            if (maxLen < min) {
                maxLen = min;
                size = 1;
            } else if (maxLen == min) {
                size++;
            }
        }
        return size;
    }

}
