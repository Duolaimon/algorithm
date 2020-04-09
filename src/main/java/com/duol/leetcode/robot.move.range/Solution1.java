/**
 * Leetcode - robot.move.range
 */
package com.duol.leetcode.robot.move.range;

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

    public int movingCount(int m, int n, int k) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.addLast(new int[]{0, 0});
        int[][] array = new int[n][m];
        int sum = 0;
        while (!queue.isEmpty()) {
            int[] location = queue.pollFirst();
            array[location[0]][location[1]] = 1;
            if (calculate(location[0], location[1]) <= k) {
                sum++;
                if (location[0] > 0) {
                    int[] left = new int[]{location[0] - 1, location[1]};
                    if (array[left[0]][left[1]] != 1) {
                        queue.addLast(left);
                    }
                }
                if (location[0] < n - 1) {
                    int[] right = new int[]{location[0] + 1, location[1]};
                    if (array[right[0]][right[1]] != 1) {
                        queue.addLast(right);
                    }
                }
                if (location[1] > 0) {
                    int[] up = new int[]{location[0], location[1] - 1};
                    if (array[up[0]][up[1]] != 1) {
                        queue.addLast(up);
                    }
                }
                if (location[1] < m - 1) {
                    int[] down = new int[]{location[0], location[1] + 1};
                    if (array[down[0]][down[1]] != 1) {
                        queue.addLast(down);
                    }
                }
            }
        }
        return sum;
    }

    private int calculate(int x, int y) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        while (y > 0) {
            sum += y % 10;
            y /= 10;
        }
        return sum;
    }
}
