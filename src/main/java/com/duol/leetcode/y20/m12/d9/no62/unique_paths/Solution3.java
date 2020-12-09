package com.duol.leetcode.y20.m12.d9.no62.unique_paths;

/**
 * @author HeJiaGeng
 * @date 2020/12/9
 * @desc
 */
public class Solution3 implements Solution {
    @Override
    public int uniquePaths(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }
}
