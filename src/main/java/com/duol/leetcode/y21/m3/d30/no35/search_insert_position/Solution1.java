/**
 * Leetcode - search_insert_position
 */
package com.duol.leetcode.y21.m3.d30.no35.search_insert_position;

import java.util.*;

import com.duol.common.*;

/**
 * 二分查找
 */
class Solution1 implements Solution {

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return right + 1;
    }

}
