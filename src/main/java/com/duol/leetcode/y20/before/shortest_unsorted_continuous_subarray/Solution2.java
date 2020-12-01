/**
 * Leetcode - shortest_unsorted_continuous_subarray
 */
package com.duol.leetcode.y20.before.shortest_unsorted_continuous_subarray;

/**
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution2 implements Solution {

    public int findUnsortedSubarray(int[] nums) {
        int start = -1, end = -2;
        int min = 0, max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[min]) {
                if (start > min || start == -1) {
                    start = min;
                }
                end = i;
                min = i;
            } else if (nums[i] >= nums[min] && nums[i] < nums[max]) {
                int j = max;
                while (j >= 0 && nums[j] > nums[i]) {
                    j--;
                }
                if (j + 1 < start || start == -1) {
                    start = j + 1;
                }
                end = i;
            } else if (nums[i] > nums[max]) {
                max = i;
            }
        }
        return end - start + 1;
    }

}
