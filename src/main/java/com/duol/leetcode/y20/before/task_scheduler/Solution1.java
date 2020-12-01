/**
 * Leetcode - least_interval
 */
package com.duol.leetcode.y20.before.task_scheduler;

import java.util.Arrays;

/**
 * A:65
 */
class Solution1 implements Solution {

    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }
        Arrays.sort(map);
        int max_val = map[25] - 1, idle_slots = max_val * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            idle_slots -= Math.min(map[i], max_val);
        }
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }

    public static void main(String[] args) {
        System.out.println((int) 'A');
    }
}
