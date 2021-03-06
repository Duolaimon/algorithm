/**
 * Leetcode - best_sightseeing_pair
 */
package com.duol.leetcode.y20.before.best_sightseeing_pair;

/**
 * 我们考虑从前往后枚举 jj 来统计答案，对于每个观光景点 jj 而言，我们需要遍历 [0,j-1][0,j−1] 的观光景点 ii 来计算组成观光组合 (i,j)(i,j) 得分的最大值 \textit{cnt}_jcnt
 * j
 * ​
 *   来作为第 jj 个观光景点的值，那么最后的答案无疑就是所有观光景点值的最大值，即 \max_{j=0..n-1}\{cnt_j\}max
 * j=0..n−1
 * ​
 *  {cnt
 * j
 * ​
 *  }。但是枚举 jj 需要 O(n)O(n) 的时间复杂度，遍历 [0,j-1][0,j−1] 的观光景点 ii 也需要 O(n)O(n) 的时间复杂度，因此该方法总复杂度为 O(n^2)O(n
 * 2
 *  )，不能通过所有测试用例，我们需要进一步优化时间复杂度。
 *
 * 我们回过头来看得分公式，我们可以将其拆分成 A[i]+iA[i]+i 和 A[j]-jA[j]−j 两部分，这样对于统计景点 jj 答案的时候，由于 A[j]-jA[j]−j 是固定不变的，
 * 因此最大化 A[i]+i+A[j]-jA[i]+i+A[j]−j 的值其实就等价于求 [0,j-1][0,j−1] 中 A[i]+iA[i]+i 的最大值 mxmx，景点 jj 的答案即为 mx+A[j]-jmx+A[j]−j 。而 mxmx 的值我们只要从前往后枚举 jj 的时候同时维护即可，这样每次枚举景点 jj 的时候，寻找使得得分最大的 ii 就能从 O(n)O(n) 降至 O(1)O(1) 的时间复杂度，总时间复杂度就能从 O(n^2)O(n
 * 2
 *  ) 降至 O(n)O(n)。
 */
class Solution2 implements Solution {

    public int maxScoreSightseeingPair(int[] A) {
        int ans = 0, mx = A[0];
        for (int j = 1; j < A.length; ++j) {
            ans = Math.max(ans, mx + A[j] - j);
            // 边遍历边维护
            mx = Math.max(mx, A[j] + j);
        }
        return ans;
    }
}
