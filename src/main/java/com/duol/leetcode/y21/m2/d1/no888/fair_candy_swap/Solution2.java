/**
 * Leetcode - fair_candy_swap
 */
package com.duol.leetcode.y21.m2.d1.no888.fair_candy_swap;
import java.util.*;
import com.duol.common.*;

/** 
 * hash
 * O(N)
 */
class Solution2 implements Solution {

    public int[] fairCandySwap(int[] A, int[] B){
        int sumA = 0, sumB = 0;
        for (int i : A) {
            sumA += i;
        }
        for (int i : B) {
            sumB += i;
        }
        int sub = (sumA - sumB) / 2;
        Set<Integer> hash = new HashSet<>(B.length);
        for (int j : B) {
            hash.add(j + sub);
        }
        for (int i : A) {
            if (hash.contains(i)) {
                return new int[]{i, i - sub};
            }
        }
        return null;
    }

}
