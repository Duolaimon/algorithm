/**
 * Leetcode - two_sum
 */
package com.duol.leetcode.y20.m12.d25.no1.two_sum;
import java.util.*;
import com.duol.common.*;

/** 
 * hash法
 */
class Solution2 implements Solution {

    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                // 目标值存在
                return new int[]{map.get(target - nums[i]), i};
            }else{
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }

}
