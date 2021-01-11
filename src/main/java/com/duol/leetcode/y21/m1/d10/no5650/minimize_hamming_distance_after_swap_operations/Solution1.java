/**
 * Leetcode - minimize_hamming_distance_after_swap_operations
 */
package com.duol.leetcode.y21.m1.d10.no5650.minimize_hamming_distance_after_swap_operations;

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

    private Map<Integer, Integer> parent;
    private Map<Integer, List<Integer>> indexValuesMap;

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        parent = new HashMap<>(source.length);
        // 下标-可以的值
        indexValuesMap = new HashMap<>(source.length);
        for (int[] allowedSwap : allowedSwaps) {
            merge(source, allowedSwap[0], allowedSwap[1]);
        }
        int res = 0;
        for (int i = 0; i < source.length; i++) {
            List<Integer> values = indexValuesMap.get(find(source, i));
            if (values.contains(target[i])) {
                values.remove(target[i]);
            } else {
                res++;
            }
        }
        return res;
    }

    private int find(int[] source, int a) {
        if (parent.containsKey(a) && parent.get(a) != a) {
            parent.put(a, find(source, parent.get(a)));
        } else {
            ArrayList<Integer> values = new ArrayList<>();
            values.add(source[a]);
            indexValuesMap.put(a, values);
            parent.put(a, a);
        }
        return parent.get(a);
    }

    private void merge(int[] source, int a, int b) {
        int parA = find(source, a);
        int parB = find(source, b);
        if (parA == parB) {
            return;
        }
        parent.put(parB, parA);
        indexValuesMap.get(parA).addAll(indexValuesMap.get(parB));
    }


}
