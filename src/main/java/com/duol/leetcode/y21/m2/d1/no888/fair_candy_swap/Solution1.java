/**
 * Leetcode - fair_candy_swap
 */
package com.duol.leetcode.y21.m2.d1.no888.fair_candy_swap;

import java.util.*;

import com.duol.common.*;

/**
 * 排序，指针比较
 * O(N * logN)
 */
class Solution1 implements Solution {

    public int[] fairCandySwap(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int sumA = 0, sumB = 0;
        for (int i : A) {
            sumA += i;
        }
        for (int i : B) {
            sumB += i;
        }
        int sub = (sumA - sumB) / 2;
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] - B[j] == sub) {
                return new int[]{A[i], B[j]};
            }
            if (A[i] - B[j] > sub) {
                j++;
            } else {
                i++;
            }
        }
        return null;
    }

}
