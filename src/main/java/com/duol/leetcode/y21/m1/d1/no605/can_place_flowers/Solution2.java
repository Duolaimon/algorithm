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
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution2 implements Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n){
        // 每次跳两格
        for (int i = 0; i < flowerbed.length; i += 2) {
            // 如果当前为空地
            if (flowerbed[i] == 0) {
                // 如果是最后一格或者下一格为空
                if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                    n--;
                } else {
                    i++;
                }
            }
        }
        return n <= 0;

    }

}
