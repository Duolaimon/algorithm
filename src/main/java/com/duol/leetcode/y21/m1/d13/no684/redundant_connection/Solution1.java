/**
 * Leetcode - redundant_connection
 */
package com.duol.leetcode.y21.m1.d13.no684.redundant_connection;

import java.util.*;

import com.duol.common.*;

/**
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution1 implements Solution {

    public int[] findRedundantConnection(int[][] edges) {
        int max = 0;
        for (int[] edge : edges) {
            for (int j = 0; j < 2; j++) {
                if (edge[j] > max) {
                    max = edge[j];
                }
            }
        }
        UnionFind uf = new UnionFind(max + 1);
        for (int[] edge : edges) {
            boolean merge = uf.merge(edge[0], edge[1]);
            if (!merge) {
                return edge;
            }
        }
        return null;
    }

    class UnionFind {
        int[] parent;

        public UnionFind(int length) {
            this.parent = new int[length];
        }

        int find(int a) {
            int par = parent[a];
            if (par == 0) {
                parent[a] = a;
                return a;
            }
            if (par != a) {
                parent[a] = find(par);
            }
            return parent[a];
        }

        boolean merge(int a, int b) {
            int parA = find(a);
            int parB = find(b);
            if (parA == parB) {
                return false;
            }
            parent[parA] = parB;
            return true;
        }
    }

}
