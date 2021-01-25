/**
 * Leetcode - regions_cut_by_slashes
 */
package com.duol.leetcode.y21.m1.d25.no959.regions_cut_by_slashes;

import java.util.*;

import com.duol.common.*;

/**
 * 作者：fe-lucifer
 * 链接：https://leetcode-cn.com/problems/regions-cut-by-slashes/solution/liang-chong-fang-fa-bing-cha-ji-he-dfs95-uhof/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution2 implements Solution {

    public int regionsBySlashes(String[] grid) {
        int length = grid.length;
        int[][] newGrid = new int[3 * length][3 * length];
        int ans = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i].charAt(j) == '/') {
                    newGrid[3 * i][3 * j + 2] = 1;
                    newGrid[3 * i + 1][3 * j + 1] = 1;
                    newGrid[3 * i + 2][3 * j] = 1;
                }
                if (grid[i].charAt(j) == '\\') {
                    newGrid[3 * i][3 * j] = 1;
                    newGrid[3 * i + 1][3 * j + 1] = 1;
                    newGrid[3 * i + 2][3 * j + 2] = 1;
                }
            }
        }
        for (int i = 0; i < 3 * length; i++) {
            for (int j = 0; j < 3 * length; j++) {
                if (newGrid[i][j] == 0) {
                    ans++;
                    dfs(newGrid, i, j, length);
                }
            }
        }
        return ans;

    }

    private void dfs(int[][] newGrid, int i, int j, int length) {
        if (0 <= i && i < 3 * length && 0 <= j && j < 3 * length && newGrid[i][j] == 0) {
            newGrid[i][j] = 1;
            dfs(newGrid, i + 1, j, length);
            dfs(newGrid, i - 1, j, length);
            dfs(newGrid, i, j + 1, length);
            dfs(newGrid, i, j - 1, length);
        }
    }

}
