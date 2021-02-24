/**
 * Leetcode - flipping_an_image
 */
package com.duol.leetcode.y21.m2.d24.no832.flipping_an_image;

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

    public int[][] flipAndInvertImage(int[][] A) {
        int[][] res = new int[A.length][];
        for (int i = 0; i < A.length; i++) {
            int[] cur = A[i];
            int len = cur.length;
            int[] r = new int[len];
            for (int j = len - 1; j >= 0; j--) {
                r[len - j - 1] = cur[j] ^ 1;
            }
            res[i] = r;
        }
        return res;
    }

}
