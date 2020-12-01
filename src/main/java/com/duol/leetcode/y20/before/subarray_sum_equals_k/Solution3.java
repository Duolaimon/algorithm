package com.duol.leetcode.y20.before.subarray_sum_equals_k;

/**
 * @author HeJiaGeng
 * @date 2020/1/24
 * @desc
 */
public class Solution3 implements Solution {
    @Override
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            sum += n;
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }
        int[] sums = new int[max - min + 1];
        int count = 0;
        sum = 0;
        for (int n : nums) {
            sum += n;
            int target = sum - min - k;
            if (target >= 0 && target < sums.length) {
                count += sums[target];
            }
            sums[sum - min]++;
        }
        if (k - min >= 0 && k - min < sums.length) {
            count += sums[k - min];
        }
        return count;
    }
}
