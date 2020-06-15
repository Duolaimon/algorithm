/**
 * Leetcode - allocate_mailboxes
 */
package com.duol.leetcode.allocate_mailboxes;
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

    public int minDistance(int[] houses, int k){
        Arrays.sort(houses);
        int[] between = new int[houses.length - 1];
        for (int i = 1; i < houses.length; i++) {
            between[i - 1] = houses[i] - houses[i - 1];
        }
        return 0;
    }

}
