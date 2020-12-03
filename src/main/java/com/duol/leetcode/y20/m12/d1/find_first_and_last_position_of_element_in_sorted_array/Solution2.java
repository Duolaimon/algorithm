/**
 * Leetcode - find_first_and_last_position_of_element_in_sorted_array
 */
package com.duol.leetcode.y20.m12.d1.find_first_and_last_position_of_element_in_sorted_array;

/**
 * 二分查找
 * O(logN)
 */
class Solution2 implements Solution {

    public int[] searchRange(int[] nums, int target) {
        int find = searchRangeHelper(nums, target);
        //如果没找到，返回{-1, -1}
        if (find == -1)
            return new int[]{-1, -1};
        int left = find - 1;
        int right = find + 1;
        //查看前面是否还有target
        while (left >= 0 && nums[left] == target)
            left--;
        //查看后面是否还有target
        while (right < nums.length && nums[right] == target)
            right++;
        return new int[]{left + 1, right - 1};
    }

    //二分法查找
    public int searchRangeHelper(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = nums[mid];
            if (midVal < target) {
                low = mid + 1;
            } else if (midVal > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
