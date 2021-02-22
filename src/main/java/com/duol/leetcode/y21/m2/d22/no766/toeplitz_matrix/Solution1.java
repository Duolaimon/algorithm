/**
 * Leetcode - toeplitz_matrix
 */
package com.duol.leetcode.y21.m2.d22.no766.toeplitz_matrix;

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

    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (!isToeplitzMatrix(matrix, m, n, i, 0)) {
                return false;
            }
        }
        for (int j = 0; j < n; j++) {
            if (!isToeplitzMatrix(matrix, m, n, 0, j)) {
                return false;
            }
        }
        return true;
    }

    boolean isToeplitzMatrix(int[][] matrix, int m, int n, int i, int j) {
        int t = matrix[i][j];
        while (i < m && j < n) {
            if (matrix[i][j] != t) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
