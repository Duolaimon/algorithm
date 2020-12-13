/**
 * Leetcode - wiggle_subsequence
 */
package com.duol.leetcode.y20.m12.d12.no376.wiggle_subsequence;

import java.util.*;

import com.duol.common.*;

/**
 *
 */
class Solution1 implements Solution {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = 1;
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] == nums[i + 1]) {
                i++;
                continue;
            } else if (nums[i] > nums[i + 1]) {
                while (i < nums.length - 1 && nums[i] >= nums[i + 1]) {

                    i++;
                }
            } else if (nums[i] < nums[i + 1]) {
                while (i < nums.length - 1 && nums[i] <= nums[i + 1]) {

                    i++;
                }
            }
            result++;
        }
        return result;
    }

}
