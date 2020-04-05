/**
 * Leetcode - trap
 */
package com.duol.leetcode.trap;

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

    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int left = 0;
        int result = 0;
        while (left < height.length) {
            int ltMax = left + 1;
            for (int i = left + 1; i < height.length; i++) {
                //右侧比当前大的第一个
                if (height[i] >= height[left]) {
                    for (int j = left + 1; j < i; j++) {
                        result += height[left] - height[j];
                    }
                    left = i;
                    ltMax = left + 1;
                } else if (height[i] > height[ltMax]) {
                    ltMax = i;
                }
            }
            //右侧比当前小的最大的
            for (int j = left + 1; j < ltMax; j++) {
                result += height[ltMax] - height[j];
            }
            left = ltMax;
        }
        return result;
    }

}
