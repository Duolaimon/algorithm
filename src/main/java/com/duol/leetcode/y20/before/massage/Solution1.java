/**
 * Leetcode - massage
 */
package com.duol.leetcode.y20.before.massage;

/**
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution1 implements Solution {

    public int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        sum[1] = nums[1];
        sum[2] = nums[2] + nums[0];
        for (int i = 3; i < nums.length; i++) {
            sum[i] = nums[i] + Math.max(sum[i - 2], sum[i - 3]);
        }
        return Math.max(sum[nums.length - 1], sum[nums.length - 2]);
    }

}
