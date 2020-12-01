/**
 * Leetcode - queue_reconstruction_by_height
 */
package com.duol.leetcode.y20.before.queue_reconstruction_by_height;

import java.util.*;

/**
 * 排序后插入
 * 身高高的在前，相同身高则index小的在前
 */
class Solution1 implements Solution {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        List<int[]> output = new LinkedList<>();
        for (int[] p : people) {
            output.add(p[1], p);
        }

        int n = people.length;
        return output.toArray(new int[n][2]);
    }

}
