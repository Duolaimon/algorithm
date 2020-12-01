/**
 * Leetcode - partition_equal_subset_sum
 */
package com.duol.leetcode.y20.before.partition_equal_subset_sum;

/**
 * 回溯法
 */
class Solution2 implements Solution {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int half = sum / 2;
        return canPartition(nums, 0, half);
    }

    private boolean canPartition(int[] nums, int index, int target) {
        if (target == 0) {
            return true;
        }
        if (index == nums.length || target < 0) {
            return false;
        }
        if (canPartition(nums, index + 1, target - nums[index])) {
            return true;
        }
        //1 1 1 100
        //跳过相同的数
        int j = index + 1;
        while (j < nums.length && nums[index] == nums[j]) {
            j++;
        }
        return canPartition(nums, j, target);
    }

}
