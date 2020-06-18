/**
 * Leetcode - best_sightseeing_pair
 */
package com.duol.leetcode.best_sightseeing_pair;
import java.util.*;
import com.duol.common.*;

/**
 *
 * not ac
 *
 * O(n^2)
 */
class Solution1 implements Solution {

    public int maxScoreSightseeingPair(int[] A){
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int cur = A[i] + A[j] + i - j;
                if (cur > max) {
                    max = cur;
                }
            }
        }
        return max;
    }

}
