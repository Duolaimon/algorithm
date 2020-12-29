/**
 * Leetcode - patching_array
 */
package com.duol.leetcode.y20.m12.d29.no330.patching_array;

import java.util.*;

import com.duol.common.*;

/**
 *
 */
class Solution2 implements Solution {

    public int minPatches(int[] nums, int n) {
        if (n < 1)
            return 0;
        int i = 0, res = 0;
        long miss = 1;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss)
                miss += nums[i++];
            else {
                miss += miss;
                ++res;
            }
        }
        return res;
    }

}
