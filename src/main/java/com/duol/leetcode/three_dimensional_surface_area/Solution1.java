/**
 * Leetcode - three_dimensional_surface_area
 */
package com.duol.leetcode.three_dimensional_surface_area;

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

    public int surfaceArea(int[][] grid) {
        int surface = 0;
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                int cur = 4 * grid[i][j] + 2;
                if (i > 0) {
                    cur = cur - Math.min(grid[i][j], grid[i - 1][j]) * 2;
                }
                if (j > 0) {
                    cur = cur - Math.min(grid[i][j], grid[i][j - 1]) * 2;
                }
                surface += cur;
            }
        }
        return surface;
    }

}
