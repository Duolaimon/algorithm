/**
 * Leetcode - last_stone_weight
 */
package com.duol.leetcode.y20.m12.d30.no1046.last_stone_weight;
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
class Solution2 implements Solution {

    public int lastStoneWeight(int[] stones){
        int[] hash = new int[1001];
        for (int stone : stones) {
            hash[stone]++;
        }
        int x = 1000;
        int y;
        while (true) {
            while (x > 0 && hash[x] == 0) {
                x--;
            }
            if (x == 0) {
                return 0;
            }
            hash[x]--;
            y = x;
            while (y > 0 && hash[y] == 0) {
                y--;
            }
            hash[y]--;
            if (y == 0) {
                return x;
            }
            hash[x - y]++;
        }
    }

}
