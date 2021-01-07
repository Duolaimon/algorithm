/**
 * Leetcode - number_of_provinces
 */
package com.duol.leetcode.y21.m1.d7.no547.number_of_provinces;

import java.util.*;

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

    private int find(int i, Map<Integer, Integer> parent) {
        if (parent.containsKey(i)) {
            int par = parent.get(i);
            if (Objects.equals(par, i)) {
                return par;
            } else {
                return find(par, parent);
            }
        }
        parent.put(i, i);
        return i;
    }

    private void merge(int i, int j, Map<Integer, Integer> parent) {
        int parI = find(i, parent);
        int parJ = find(j, parent);
        if (Objects.equals(parI, parJ)) {
            return;
        }
        parent.put(parJ, parI);
    }

    public int findCircleNum(int[][] isConnected) {
        Map<Integer, Integer> parent = new HashMap<>();
        int n = isConnected.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isConnected[i][j] == 1)
                    merge(i, j, parent);
            }
        }
        Set<Integer> provinces = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int province = find(i, parent);
            provinces.add(province);
        }
        return provinces.size();
    }

}
