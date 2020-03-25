/**
 * Leetcode - create_target_array_in_the_given_order
 */
package com.duol.leetcode.create_target_array_in_the_given_order;
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

    public int[] createTargetArray(int[] nums, int[] index){
        List<Integer> target = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            target.add(index[i], nums[i]);
        }
        int[] targetArr = new int[target.size()];
        for (int i = 0; i < target.size(); i++) {
            targetArr[i] = target.get(i);
        }
        return targetArr;
    }

}
