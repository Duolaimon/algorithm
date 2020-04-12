/**
 * Leetcode - super.egg.drop
 */
package com.duol.leetcode.egg.drop;

import java.util.*;

import com.duol.common.*;

/**
 * 方法三：数学法
 * 说明
 *
 * 方法三涉及逆向思维，是一种没见过就不太可能想出来，读过题解也很容易忘记的方法。
 *
 * 思路
 *
 * 反过来想这个问题：如果我们可以做 TT 次操作，而且有 KK 个鸡蛋，那么我们能找到答案的最高的 NN 是多少？
 * 我们设 f(T, K)f(T,K) 为在上述条件下的 NN。如果我们求出了所有的 f(T, K)f(T,K)，
 * 那么只需要找出最小的满足 f(T, K) \geq Nf(T,K)≥N 的 TT。
 *
 * 那么我们如何求出 f(T, K)f(T,K) 呢？我们还是使用动态规划。因为我们需要找出最高的 NN，
 * 因此我们不必思考到底在哪里扔这个鸡蛋，我们只需要扔出一个鸡蛋，看看到底发生了什么：
 *
 * 如果鸡蛋没有碎，那么对应的是 f(T - 1, K)f(T−1,K)，也就是说在这一层的上方可以有 f(T - 1, K)f(T−1,K) 层；
 *
 * 如果鸡蛋碎了，那么对应的是 f(T - 1, K - 1)f(T−1,K−1)，也就是说在这一层的下方可以有 f(T - 1， K - 1)f(T−1，K−1) 层。
 *
 * 因此我们就可以写出状态转移方程：
 *
 * f(T, K) = 1 + f(T-1, K-1) + f(T-1, K)
 * f(T,K)=1+f(T−1,K−1)+f(T−1,K)
 *
 * 边界条件为：当 T \geq 1T≥1 的时候 f(T, 1) = Tf(T,1)=T，当 K \geq 1K≥1 时，f(1, K) = 1f(1,K)=1。
 *
 * 那么问题来了：TT 最大可以达到多少？由于我们在进行动态规划时，TT 在题目中并没有给出，那么我们需要进行到动态规划的哪一步呢？
 * 可以发现，操作次数是一定不会超过楼层数的，因此 T \leq NT≤N，我们只要算出在 f(N, K)f(N,K) 内的所有 ff 值即可。
 */
class Solution1 implements Solution {

    public int superEggDrop(int K, int N) {
        if (N == 1) {
            return 1;
        }
        int[][] f = new int[N + 1][K + 1];
        for (int i = 1; i <= K; ++i) {
            f[1][i] = 1;
        }
        int ans = -1;
        for (int i = 2; i <= N; ++i) {
            for (int j = 1; j <= K; ++j) {
                f[i][j] = 1 + f[i - 1][j - 1] + f[i - 1][j];
            }
            if (f[i][K] >= N) {
                ans = i;
                break;
            }
        }
        return ans;
    }

}
