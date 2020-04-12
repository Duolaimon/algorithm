/**
 * Leetcode - super.egg.drop
 */
package com.duol.leetcode.egg.drop;
import java.util.*;
import com.duol.common.*;

/** 
 * 方法二：决策单调性
 * 说明
 *
 * 方法二涉及决策单调性，是竞赛中的考点。这里我们不会叙述 何为决策单调性 以及 如何根据决策单调性写出优化的动态规划，而是仅指出决策单调性的存在性。
 *
 * 思路
 *
 * 我们重新写下方法一中的状态转移方程：
 *
 * dp(K, N) = 1 + \min\limits_{1 \leq X \leq N} \Big( \max(dp(K-1, X-1), dp(K, N-X)) \Big)
 * dp(K,N)=1+
 * 1≤X≤N
 * min
 * ​
 *  (max(dp(K−1,X−1),dp(K,N−X)))
 *
 * 并且假设 X_\textit{opt}X
 * opt
 * ​
 *   是使得 dp(K, N)dp(K,N) 取到最优值的最小决策点 X_0X
 * 0
 * ​
 *  。
 *
 * X_\textit{opt} = \arg \min\limits_{1 \leq X \leq N} \Big( \max(dp(K-1, X-1), dp(K, N-X)) \Big)
 * X
 * opt
 * ​
 *  =arg
 * 1≤X≤N
 * min
 * ​
 *  (max(dp(K−1,X−1),dp(K,N−X)))
 *
 * 在方法一中，我们是通过二分查找的方法，找到 X_0X
 * 0
 * ​
 *   和 X_1X
 * 1
 * ​
 *   中最优的作为 X_\textit{opt}X
 * opt
 * ​
 *   的，那么还有什么更好的方法吗？
 *
 * 我们固定 KK，随着 NN 的增加，对于状态转移方程中 dp(K-1, X-1)dp(K−1,X−1) 这一项，它的值是不变的，因为它和 NN 无关。而对于状态转移方程中 dp(K, N-X)dp(K,N−X) 这一项，随着 NN 的增加，它的值也会增加。在方法一中，我们知道 dp(K-1, X-1)dp(K−1,X−1) 随着 XX 单调递增，而 dp(K, N-X)dp(K,N−X) 随着 XX 单调递减，那么当 NN 增加时，dp(K, N-X)dp(K,N−X) 对应的函数折线图在每个整数点上都是增加的，因此在 dp(K-1, X-1)dp(K−1,X−1) 不变的情况下，X_\textit{opt}X
 * opt
 * ​
 *   是单调递增的。
 *
 * 我们可以想象一条斜率为负的直线和一条斜率为正的直线，当斜率为负的直线（类比 dp(K, N-X)dp(K,N−X)）向上平移（类比 NN 的增加）时，它和斜率为正的直线（类比 dp(K-1, X-1)dp(K−1,X−1)）的交点会一直向右移动，这个交点就确定了 X_\textit{opt}X
 * opt
 * ​
 *  ，这与方法一也是一致的。
 *
 * 因此当我们固定 KK 时，随着 NN 的增加，dp(K, N)dp(K,N) 对应的最优解的坐标 X_\textit{opt}X
 * opt
 * ​
 *   单调递增，这样一来每个 dp(K, N)dp(K,N) 的均摊时间复杂度为 O(1)O(1)。
 *
 */
class Solution2 implements Solution {

    public int superEggDrop(int K, int N){
        // Right now, dp[i] represents dp(1, i)
        int[] dp = new int[N+1];
        for (int i = 0; i <= N; ++i)
            dp[i] = i;

        for (int k = 2; k <= K; ++k) {
            // Now, we will develop dp2[i] = dp(k, i)
            int[] dp2 = new int[N+1];
            int x = 1;
            for (int n = 1; n <= N; ++n) {
                // Let's find dp2[n] = dp(k, n)
                // Increase our optimal x while we can make our answer better.
                // Notice max(dp[x-1], dp2[n-x]) > max(dp[x], dp2[n-x-1])
                // is simply max(T1(x-1), T2(x-1)) > max(T1(x), T2(x)).
                while (x < n && Math.max(dp[x-1], dp2[n-x]) > Math.max(dp[x], dp2[n-x-1]))
                    x++;

                // The final answer happens at this x.
                dp2[n] = 1 + Math.max(dp[x-1], dp2[n-x]);
            }

            dp = dp2;
        }

        return dp[N];
    }

}
