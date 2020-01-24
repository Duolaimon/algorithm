package com.duol.leetcode.shortest_unsorted_continuous_subarray;

/**
 * @author HeJiaGeng
 * @date 2020/1/24
 * @desc
 */
public class Solution3 implements Solution {
    @Override
    public int findUnsortedSubarray(int[] nums) {
        int start = 0, end = -1;
        int max = nums[0];
        int min = nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            if (max > nums[i]) {
                end = i;
            } else {
                max = nums[i];
            }
            if (min < nums[nums.length - i - 1]) {
                start = nums.length - i - 1;
            } else {
                min = nums[nums.length - i - 1];
            }
        }
        return end - start + 1;
    }
}
