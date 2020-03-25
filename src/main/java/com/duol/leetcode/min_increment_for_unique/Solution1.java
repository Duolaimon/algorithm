/**
 * Leetcode - min_increment_for_unique
 */
package com.duol.leetcode.min_increment_for_unique;
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
class Solution1 implements Solution {

    public int minIncrementForUnique(int[] A){
        boolean[] arr = new boolean[40000 + A.length];
        int move = 0;
        for (int value : A) {
            int cur = value;
            while (arr[cur]) {
                cur++;
                move++;
            }
            arr[cur] = true;
        }
        return move;
    }

}
