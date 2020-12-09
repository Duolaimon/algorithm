/**
 * Leetcode - find_first_and_last_position_of_element_in_sorted_array
 */
package com.duol.leetcode.y20.m12.d1.no34.find_first_and_last_position_of_element_in_sorted_array;

/** 
 * 顺序查找
 * O(N)
 */
class Solution1 implements Solution {

    public int[] searchRange(int[] nums, int target){
        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (start == -1) {
                    start = i;
                }
                end = i;
            }
        }
        return new int[]{start, end};
    }

}
