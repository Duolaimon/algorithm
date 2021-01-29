/**
 * Leetcode - path_with_minimum_effort
 */
package com.duol.leetcode.y21.m1.d29.no1631.path_with_minimum_effort;

import java.util.*;

import com.duol.common.*;

/**
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/path-with-minimum-effort/solution/zui-xiao-ti-li-xiao-hao-lu-jing-by-leetc-3q2j/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution1 implements Solution {

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int left = 0;
        int right = (int) (Math.pow(10, 6)) - 1;
        int ans = 0;
        // 二分
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean[][] seen = new boolean[m][n];
            seen[0][0] = true;
            bfs(heights, m, n, mid, seen);
            if (seen[m - 1] [n - 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private void bfs(int[][] heights, int m, int n, int mid, boolean[][] seen) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            for (int i = 0; i < 4; ++i) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !seen[nx][ny] && Math.abs(heights[x][y] - heights[nx][ny]) <= mid) {
                    queue.offer(new int[]{nx, ny});
                    seen[nx][ny] = true;
                }
            }
        }
    }

}
