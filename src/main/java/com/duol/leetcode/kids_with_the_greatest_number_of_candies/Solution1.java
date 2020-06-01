/**
 * Leetcode - kids_with_the_greatest_number_of_candies
 */
package com.duol.leetcode.kids_with_the_greatest_number_of_candies;

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

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>(candies.length);
        int defaultMax = 0;
        for (int candy : candies) {
            if (candy > defaultMax) {
                defaultMax = candy;
            }
        }
        for (int i = 0; i < candies.length; i++) {
            res.add(i, candies[i] + extraCandies >= defaultMax);
        }
        return res;
    }

}
