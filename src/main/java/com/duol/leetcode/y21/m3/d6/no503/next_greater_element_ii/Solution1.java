/**
 * Leetcode - next_greater_element_ii
 */
package com.duol.leetcode.y21.m3.d6.no503.next_greater_element_ii;
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

    public int[] nextGreaterElements(int[] nums){
        int length = nums.length;
        int maxIndex = 0;
        for (int i = 1; i < length; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }
        int[] index = new int[length];
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            if (nums[maxIndex] == nums[i]) {
                index[i] = maxIndex;
                res[i] = -1;
            }
        }
        for (int i = maxIndex - 1; i >= 0; i--) {
            int next = (i + 1) % length;
            while (next != maxIndex && nums[next] <= nums[i]) {
                next = index[next];
            }
            index[i] = next;
            res[i] = nums[next];
        }
        for (int i = length - 1; i > maxIndex; i--) {
            int next = (i + 1) % length;
            while (next != maxIndex && nums[next] <= nums[i]) {
                next = index[next];
            }
            if (nums[next] > nums[i]) {
                index[i] = next;
                res[i] = nums[next];
            }
        }
        return res;
    }

}
