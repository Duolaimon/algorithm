/**
 * Leetcode - non_decreasing_array
 */
package com.duol.leetcode.y21.m2.d7.no665.non_decreasing_array;

import java.util.*;

import com.duol.common.*;

/**
 *
 */
class Solution1 implements Solution {

    public boolean checkPossibility(int[] nums) {
        int left = 0;
        while (left + 1 < nums.length && nums[left] <= nums[left + 1]) {
            left++;
        }
        if (left == nums.length - 1) {
            return true;
        }
        int right = nums.length - 1;
        while (right >= 1 && nums[right - 1] <= nums[right]) {
            right--;
        }
        if (right - left > 1) {
            // 不相连
            return false;
        }
        // 右侧大于左侧前一个、或左侧大于右侧后一个
        return nums[right + 1] >= nums[left] || nums[left - 1] <= nums[right];
    }

}
