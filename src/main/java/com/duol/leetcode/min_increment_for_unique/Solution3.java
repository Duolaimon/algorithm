package com.duol.leetcode.min_increment_for_unique;

import java.util.Stack;

/**
 * @author HeJiaGeng
 * @date 2020/3/22
 * @desc
 */
public class Solution3 implements Solution {
    @Override
    public int minIncrementForUnique(int[] A) {
        int[] count = new int[80000];
        for (int x: A) count[x]++;

        int ans = 0, taken = 0;

        for (int x = 0; x < 80000; ++x) {
            if (count[x] >= 2) {
                taken += count[x] - 1;
                ans -= x * (count[x] - 1);
            }
            else if (taken > 0 && count[x] == 0) {
                taken--;
                ans += x;
            }
        }

        return ans;
    }
}
