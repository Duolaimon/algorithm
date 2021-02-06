/**
 * Leetcode - maximum_points_you_can_obtain_from_cards
 */
package com.duol.leetcode.y21.m2.d6.no1423.maximum_points_you_can_obtain_from_cards;

import java.util.Arrays;

/**
 * 滑动窗口
 * 通过求出剩余卡牌点数之和的最小值，来求出拿走卡牌点数之和的最大值。
 */
class Solution3 implements Solution {

    public int maxScore(int[] cardPoints, int k) {
        int curCount = 0;
        int maxCount = 0;
        int i = 0;
        for (; i < k; i++) {
            curCount += cardPoints[i];
        }
        maxCount = curCount;
        if (k == cardPoints.length) {
            return maxCount;
        }
        int j = cardPoints.length;
        while (--i >= 0) {
            curCount -= cardPoints[i];
            curCount += cardPoints[--j];
            if (curCount > maxCount) {
                maxCount = curCount;
            }
        }
        return maxCount;
    }

}
