/**
 * Leetcode - spiral_matrix_ii
 */
package com.duol.leetcode.y21.m3.d16.no59.spiral_matrix_ii;

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

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int up = 0, down = n - 1, left = 0, right = n - 1, index = 1;
        while (index <= n * n) {
            for (int i = left; i <= right; i++) {
                res[up][i] = index++;
            }
            up++;
            for (int i = up; i <= down; i++) {
                res[i][right] = index++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                res[down][i] = index++;
            }
            down--;
            for (int i = down; i >= up; i--) {
                res[i][left] = index++;
            }
            left++;
        }
        return res;
    }

}
