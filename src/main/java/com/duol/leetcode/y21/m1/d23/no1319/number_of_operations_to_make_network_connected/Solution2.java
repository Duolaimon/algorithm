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
class Solution2 implements Solution {

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < (n - 1)) {
            return -1;
        }
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int res = n;
        for (int[] connection : connections) {
            int p1 = find(parent, connection[0]);
            int p2 = find(parent, connection[1]);
            if (p1 != p2) {
                res--;
                parent[p2] = p1;
            }


        }
        return res - 1;
    }

    int find(int[] parent, int key) {
        if (parent[key] != key) {
            parent[key] = find(parent, parent[key]);
        }
        return parent[key];
    }

}
