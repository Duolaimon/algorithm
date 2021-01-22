/**
 * Leetcode - add_to_array_form_of_integer
 */
package com.duol.leetcode.y21.m1.d22.no989.add_to_array_form_of_integer;
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

    public List<Integer> addToArrayForm(int[] A, int K){
        List<Integer> res = new ArrayList<>();
        int p = K;
        for (int i = A.length - 1; i >= 0; i--) {
            A[i] = A[i] + p;
            p = A[i] / 10;
            res.add(A[i] % 10);
        }
        while (p > 0) {
            res.add(p % 10);
            p = p / 10;
        }
        Collections.reverse(res);
        return res;
    }

}
