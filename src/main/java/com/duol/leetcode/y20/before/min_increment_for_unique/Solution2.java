/**
 * Leetcode - min_increment_for_unique
 */
package com.duol.leetcode.y20.before.min_increment_for_unique;
import java.util.*;

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

    public int minIncrementForUnique(int[] A){
        if (A.length == 0) {
            return 0;
        }
        Arrays.sort(A);
        int pre = A[0];
        int move = 0;
        for (int i = 1; i < A.length; i++) {
            int cur = A[i];
            while (cur <= pre) {
                cur++;
                move++;
            }
            pre = cur;
        }
        return move;
    }

}
