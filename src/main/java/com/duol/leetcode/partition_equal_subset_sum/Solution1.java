/**
 * Leetcode - partition_equal_subset_sum
 */
package com.duol.leetcode.partition_equal_subset_sum;
import java.util.*;
import com.duol.common.*;

/** 
 * 背包法，动态规划
 */
class Solution1 implements Solution {

    public boolean canPartition(int[] nums){
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int half = sum / 2;
        int[] array = new int[half + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = half; j >= nums[i]; j--) {
                array[j] = Math.max(array[j], array[j - nums[i]] + nums[i]);
            }
        }
        return array[half] == half;
    }

}
