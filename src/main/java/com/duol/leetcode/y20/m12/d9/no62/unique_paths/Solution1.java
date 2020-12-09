/**
 * Leetcode - unique_paths
 */
package com.duol.leetcode.y20.m12.d9.no62.unique_paths;
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

    public int uniquePaths(int m, int n){
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            array[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            array[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                array[i][j] = array[i - 1][j] + array[i][j - 1];
            }
        }
        return array[m - 1][n - 1];
    }

}
