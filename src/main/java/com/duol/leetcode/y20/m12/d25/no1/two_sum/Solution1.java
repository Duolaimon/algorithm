/**
 * Leetcode - two_sum
 */
package com.duol.leetcode.y20.m12.d25.no1.two_sum;

import java.util.*;

import com.duol.common.*;

/**
 * 排序，收尾双指针
 */
class Solution1 implements Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] sortNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortNums);
        int left = 0;
        int right = sortNums.length - 1;
        while (left < right) {
            int sum = sortNums[left] + sortNums[right];
            if (sum == target) {
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == sortNums[left]) {
                index1 = i;
            }
        }
        for (int i = nums.length - 1; i >= 0  ; i--) {
            if (nums[i] == sortNums[right]) {
                index2 = i;
            }
        }
        return new int[]{index1, index2};
    }

}
