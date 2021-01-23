/**
 * Leetcode - number_of_operations_to_make_network_connected
 */
package com.duol.leetcode.y21.m1.d23.no1319.number_of_operations_to_make_network_connected;

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

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        UnionFindSet unionFindSet = new UnionFindSet(n);
        for (int[] connection : connections) {
            unionFindSet.union(connection[0], connection[1]);
        }
        int noConnect = 0;
        for (int i = 0; i < n; i++) {
            if (unionFindSet.find(i) == i) {
                noConnect++;
            }
        }
        return noConnect - 1;
    }


    static class UnionFindSet {
        int[] parent;

        public UnionFindSet(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        int find(int a) {
            int aPar = parent[a];
            if (aPar != a) {
                parent[a] = find(aPar);
            }
            return parent[a];
        }

        void union(int a, int b) {
            int aPar = find(a);
            int bPar = find(b);
            if (aPar == bPar) {
                return;
            }
            parent[aPar] = bPar;
        }
    }

}
