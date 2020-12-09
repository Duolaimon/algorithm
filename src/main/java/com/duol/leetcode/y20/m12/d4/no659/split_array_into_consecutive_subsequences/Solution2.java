/**
 * Leetcode - split_array_into_consecutive_subsequences
 */
package com.duol.leetcode.y20.m12.d4.no659.split_array_into_consecutive_subsequences;

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

    public boolean isPossible(int[] nums) {
        int n = nums.length;
        int dp1 = 0, dp2 = 0, dp3 = 0;
        int i = 0;

        while (i < n) {
            int start = i;
            int x = nums[i];
            while (i < n && nums[i] == x) {
                i++;
            }
            int cnt = i - start;

            if (start > 0 && x != nums[start - 1] + 1) {
                if (dp1 + dp2 > 0) {
                    return false;
                } else {
                    dp1 = cnt;
                    dp2 = dp3 = 0;
                }
            } else {
                if (dp1 + dp2 > cnt) return false;
                int left = cnt - dp1 - dp2;
                int keep = Math.min(dp3, left);
                dp3 = keep + dp2; // 这里要注意赋值的顺序
                dp2 = dp1;
                dp1 = left - keep;
            }
        }
        return dp1 == 0 && dp2 == 0;
    }

}
