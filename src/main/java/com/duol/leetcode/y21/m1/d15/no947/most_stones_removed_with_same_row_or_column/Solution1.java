/**
 * Leetcode - most_stones_removed_with_same_row_or_column
 */
package com.duol.leetcode.y21.m1.d15.no947.most_stones_removed_with_same_row_or_column;

import java.util.*;

import com.duol.common.*;

/**
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column/solution/yi-chu-zui-duo-de-tong-xing-huo-tong-lie-m50r/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution1 implements Solution {

    public int removeStones(int[][] stones) {
        int n = stones.length;
        DisjointSetUnion dsu = new DisjointSetUnion();
        for (int i = 0; i < n; i++) {
            dsu.unionSet(stones[i][0], stones[i][1] + 10000);
        }

        return n - dsu.numberOfConnectedComponent();
    }

    static class DisjointSetUnion {
        int[] f;
        int[] rank;

        public DisjointSetUnion() {
            f = new int[20001];
            rank = new int[20001];
            Arrays.fill(f, -1);
            Arrays.fill(rank, -1);
        }

        public int find(int x) {
            if (f[x] < 0) {
                f[x] = x;
                rank[x] = 1;
            }
            return f[x] == x ? x : (f[x] = find(f[x]));
        }

        public void unionSet(int x, int y) {
            int fx = find(x), fy = find(y);
            if (fx == fy) {
                return;
            }
            if (rank[fx] < rank[fy]) {
                int temp = fx;
                fx = fy;
                fy = temp;
            }
            rank[fx] += rank[fy];
            f[fy] = fx;
        }

        public int numberOfConnectedComponent() {
            int num = 0;
            for (int i = 0; i < 20000; i++) {
                if (f[i] == i) {
                    num++;
                }
            }
            return num;
        }
    }

}
