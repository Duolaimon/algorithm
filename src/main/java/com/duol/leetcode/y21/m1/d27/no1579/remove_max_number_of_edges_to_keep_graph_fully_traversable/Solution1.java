/**
 * Leetcode - remove_max_number_of_edges_to_keep_graph_fully_traversable
 */
package com.duol.leetcode.y21.m1.d27.no1579.remove_max_number_of_edges_to_keep_graph_fully_traversable;

import java.util.*;

import com.duol.common.*;

/**
 * 作者：nekocharms
 * 链接：https://leetcode-cn.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/solution/java-bing-cha-ji-12ms-100-by-nekocharms-uzcd/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution1 implements Solution {

    class UnionFind {
        private int[] f;
        private int[] rank;
        private int Count;

        public UnionFind(int n) {
            f = new int[n + 1];
            rank = new int[n + 1];
            Count = n;
            for (int i = 0; i < n + 1; i++) {
                f[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            while (x != f[x]) {
                f[x] = f[f[x]];
                x = f[x];
            }
            return f[x];
        }

        public boolean merge(int i, int j) {
            int ri = find(i), rj = find(j);
            if (ri == rj) return true;
            if (rank[ri] < rank[rj]) {
                ri ^= rj;
                rj ^= ri;
                ri ^= rj;
            }
            f[rj] = ri;
            rank[ri] += rank[rj];
            Count--;
            return false;
        }

        public boolean isConnected() {
            return Count == 1;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind unOfalice = new UnionFind(n);
        UnionFind unOfbob = new UnionFind(n);
        int ans = 0, need = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (unOfalice.merge(edge[1], edge[2])) ans++;
                else need++;
                unOfbob.merge(edge[1], edge[2]);
            }
        }

        if (unOfalice.isConnected() && unOfbob.isConnected()) return edges.length - need;
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (unOfalice.merge(edge[1], edge[2])) ans++;
            } else if (edge[0] == 2) {
                if (unOfbob.merge(edge[1], edge[2])) ans++;
            }
        }
        if (unOfalice.isConnected() && unOfbob.isConnected()) return ans;
        return -1;
    }


}
