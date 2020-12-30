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
class Solution1 implements Solution {

    public int lastStoneWeight(int[] stones){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            priorityQueue.add(stone);
        }
        while (priorityQueue.size() > 1) {
            Integer x = priorityQueue.poll();
            Integer y = priorityQueue.poll();
            if (!Objects.equals(x, y)) {
                int sub = x - y;
                priorityQueue.add(sub);
            }
        }
        if (priorityQueue.isEmpty()) {
            return 0;
        }
        return priorityQueue.poll();
    }

}
