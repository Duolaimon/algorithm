/**
 * Leetcode - maximum_points_you_can_obtain_from_cards
 */
package com.duol.leetcode.y21.m2.d6.no1423.maximum_points_you_can_obtain_from_cards;
import java.util.*;
import com.duol.common.*;

/** 
 * 滑动窗口
 * 通过求出剩余卡牌点数之和的最小值，来求出拿走卡牌点数之和的最大值。
 */
class Solution2 implements Solution {

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        // 滑动窗口大小为 n-k
        int windowSize = n - k;
        // 选前 n-k 个作为初始值
        int sum = 0;
        for (int i = 0; i < windowSize; ++i) {
            sum += cardPoints[i];
        }
        int minSum = sum;
        for (int i = windowSize; i < n; ++i) {
            // 滑动窗口每向右移动一格，增加从右侧进入窗口的元素值，并减少从左侧离开窗口的元素值
            sum += cardPoints[i] - cardPoints[i - windowSize];
            minSum = Math.min(minSum, sum);
        }
        return Arrays.stream(cardPoints).sum() - minSum;
    }

}
