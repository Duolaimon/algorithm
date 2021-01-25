/**
 * Leetcode - longest_continuous_increasing_subsequence
 */
package com.duol.leetcode.y21.m1.d24.no674.longest_continuous_increasing_subsequence;
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

    public int findLengthOfLCIS(int[] nums){
        if (nums.length == 0) {
            return 0;
        }
        int max = 1;
        int curLen = 1;
        int preValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > preValue) {
                curLen++;
            } else {
                if (curLen > max) {
                    max = curLen;
                }
                curLen = 1;
            }
            preValue = nums[i];
        }
        return Math.max(max, curLen);
    }

}
