/**
 * Leetcode - swim_in_rising_water
 */
package com.duol.leetcode.y21.m1.d30.no778.swim_in_rising_water;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/swim-in-rising-water/solution/shui-wei-shang-sheng-de-yong-chi-zhong-y-xm9i/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution3 implements Solution {

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[] f = new int[n * n];
        for (int i = 0; i < n * n; i++) {
            f[i] = i;
        }

        int[][] idx = new int[n * n][2]; // 存储每个平台高度对应的位置
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                idx[grid[i][j]][0] = i;
                idx[grid[i][j]][1] = j;
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int threshold = 0; threshold < n * n; threshold++) {
            int i = idx[threshold][0], j = idx[threshold][1];
            for (int[] direction : directions) {
                int ni = i + direction[0], nj = j + direction[1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] <= threshold) {
                    merge(f, i * n + j, ni * n + nj);
                }
            }
            if (find(f, 0) == find(f, n * n - 1)) {
                return threshold;
            }
        }
        return -1; // cannot happen
    }

    public int find(int[] f, int x) {
        if (f[x] == x) {
            return x;
        }
        int fa = find(f, f[x]);
        f[x] = fa;
        return fa;
    }

    public void merge(int[] f, int x, int y) {
        int fx = find(f, x), fy = find(f, y);
        f[fx] = fy;
    }

}
