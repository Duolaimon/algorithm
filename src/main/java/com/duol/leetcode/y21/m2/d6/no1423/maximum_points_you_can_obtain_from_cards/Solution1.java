/**
 * Leetcode - maximum_points_you_can_obtain_from_cards
 */
package com.duol.leetcode.y21.m2.d6.no1423.maximum_points_you_can_obtain_from_cards;
import java.util.*;
import com.duol.common.*;

/** 
 * 未通过
 */
class Solution1 implements Solution {

    public int maxScore(int[] cardPoints, int k){
        return maxScore(cardPoints, 0, cardPoints.length - 1, k);
    }

    private int maxScore(int[] cardPoints, int left, int right, int k) {
        if (k == 1) {
            return Math.max(cardPoints[left], cardPoints[right]);
        }
        k--;
        return Math.max(cardPoints[left] + maxScore(cardPoints, left + 1, right, k),
                cardPoints[right] + maxScore(cardPoints, left, right - 1, k));
    }

}
