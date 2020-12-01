/**
 * Leetcode - least_interval
 */
package com.duol.leetcode.y20.before.task_scheduler;

/**
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution2 implements Solution {

    public int leastInterval(char[] tasks, int n) {
        int[] times = new int[26];
        for (char c : tasks) {
            times[c - 'A']++;
        }
        int maxTime = 0;
        int c = 0;
        for (int time : times) {
            if (time > maxTime) {
                maxTime = time;
                c = 0;
            } else if (time == maxTime) {
                c++;
            }
        }
        int r = (maxTime - 1) * (n + 1) + c + 1;
        return Math.max(r, tasks.length);
    }

}
