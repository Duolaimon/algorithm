package com.duol.leetcode.egg.drop;

/**
 * @author HeJiaGeng
 * @date 2020/4/11
 * @desc
 */
public class Solution3 implements Solution {
    @Override
    public int superEggDrop(int K, int N) {
        int[] dp = new int[K + 1];
        int ans = 0;    // 操作的次数
        while (dp[K] < N){
            for (int i = K; i > 0; i--) // 从后往前计算
                dp[i] = dp[i] + dp[i-1] + 1;
            ans++;
        }
        return ans;
    }
}
