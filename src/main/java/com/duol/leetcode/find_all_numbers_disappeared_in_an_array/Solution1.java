/**
 * Leetcode - find_all_numbers_disappeared_in_an_array
 */
package com.duol.leetcode.find_all_numbers_disappeared_in_an_array;
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

    public List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> result = new ArrayList<>();
        int[] temp = new int[nums.length + 1];
        for (int num : nums) {
            temp[num] += 1;
        }
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }

}
