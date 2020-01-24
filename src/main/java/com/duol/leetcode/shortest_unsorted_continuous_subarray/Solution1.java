/**
 * Leetcode - shortest_unsorted_continuous_subarray
 */
package com.duol.leetcode.shortest_unsorted_continuous_subarray;
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

    public int findUnsortedSubarray(int[] nums){
        int start = -1, end = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    if (start == -1) {
                        start = i;
                    }
                    if (end < j) {
                        end = j;
                    }
                    break;
                }
            }
        }
        return end - start + 1;
    }

}
