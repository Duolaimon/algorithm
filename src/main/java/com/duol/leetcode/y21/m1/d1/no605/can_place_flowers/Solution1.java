/**
 * Leetcode - can_place_flowers
 */
package com.duol.leetcode.y21.m1.d1.no605.can_place_flowers;

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

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed[0] == 0) {
            flowerbed[0] = 1;
            n--;
        }
        for (int i = 1; i < flowerbed.length; i++) {
            if (flowerbed[i - 1] == 0) {
                if (flowerbed[i] == 0) {
                    n--;
                    flowerbed[i] = 1;
                }
            } else if (flowerbed[i - 1] == 1) {
                if (flowerbed[i] == 1) {
                    flowerbed[i - 1] = 0;
                    n++;
                }
            }
        }
        return n <= 0;
    }

}
