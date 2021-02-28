/**
 * Leetcode - monotonic_array
 */
package com.duol.leetcode.y21.m2.d28.no896.monotonic_array;

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

    public boolean isMonotonic(int[] A) {
        if (A.length == 1) {
            return true;
        }
        int index = 1;
        while (index < A.length && A[index] == A[index - 1]) {
            index++;
        }
        if (index == A.length) {
            return true;
        }
        boolean dire = A[index - 1] > A[index];
        index++;
        while (index < A.length) {
            if (A[index - 1] != A[index]) {
                boolean d = A[index - 1] > A[index];
                if (d != dire) {
                    return false;
                }
            }
            index++;
        }
        return true;
    }

}
