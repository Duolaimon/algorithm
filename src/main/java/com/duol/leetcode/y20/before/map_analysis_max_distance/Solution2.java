/**
 * Leetcode - map_analysis_max_distance
 */
package com.duol.leetcode.y20.before.map_analysis_max_distance;

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

    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean f = false;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    f = true;
                    continue;
                }

                if (grid[i][j] == 0) {
                    grid[i][j] = m + n;
                }
                if (i > 0) {
                    grid[i][j] = Math.min(grid[i][j], grid[i - 1][j] + 1);
                }
                if (j > 0) {
                    grid[i][j] = Math.min(grid[i][j], grid[i][j - 1] + 1);
                }
            }
        }


        int res = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    continue;
                }

                if (i < m - 1) {
                    grid[i][j] = Math.min(grid[i][j], grid[i + 1][j] + 1);
                }
                if (j < n - 1) {
                    grid[i][j] = Math.min(grid[i][j], grid[i][j + 1] + 1);
                }

                res = Math.max(res, grid[i][j]);
            }
        }

        return f ? res - 1 : -1;
    }

}
