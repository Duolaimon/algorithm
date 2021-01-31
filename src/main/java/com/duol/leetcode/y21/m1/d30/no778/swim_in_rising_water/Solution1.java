/**
 * Leetcode - swim_in_rising_water
 */
package com.duol.leetcode.y21.m1.d30.no778.swim_in_rising_water;
import java.util.*;
import com.duol.common.*;

/** 
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution1 implements Solution {

    public int swimInWater(int[][] grid){
        int n = grid.length;
        Set<List<Integer>> seen = new HashSet<>();
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(c -> grid[c.get(0)][c.get(1)]));
        int res = 0;
        pq.add(newList(0, 0));
        while (!pq.isEmpty()) {
            List<Integer> top = pq.poll();
            if (seen.contains(top)){
                continue;
            }
            int i = top.get(0);
            int j = top.get(1);
            res = Math.max(res, grid[i][j]);
            if (i == n - 1 && j == n - 1) {
                return res;
            }
            seen.add(top);
            addIndex(pq, n, i, j + 1);
            addIndex(pq, n, i, j - 1);
            addIndex(pq, n, i + 1, j);
            addIndex(pq, n, i - 1, j);
        }
        return res;
    }

    private void addIndex(PriorityQueue<List<Integer>> pq, int n, int i, int j) {
        if (i < 0 || i >= n) {
            return;
        }
        if (j < 0 || j >= n) {
            return;
        }
        pq.add(newList(i, j));
    }

    private List<Integer> newList(int i, int j) {
        List<Integer> r = new ArrayList<>();
        r.add(i);
        r.add(j);
        return r;
    }
}
