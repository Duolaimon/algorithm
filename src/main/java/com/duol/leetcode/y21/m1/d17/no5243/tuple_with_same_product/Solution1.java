/**
 * Leetcode - tuple_with_same_product
 */
package com.duol.leetcode.y21.m1.d17.no5243.tuple_with_same_product;
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

    public int tupleSameProduct(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                map.put(product, map.getOrDefault(product, 0) + 1);
            }
        }
        int res = 0;
        for (Integer value : map.values()) {
            if (value > 1) {
                res += (value * (value - 1)) / 2 * 8;
            }
        }
        return res;
    }

}
