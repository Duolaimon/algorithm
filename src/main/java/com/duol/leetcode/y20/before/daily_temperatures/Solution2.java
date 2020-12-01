/**
 * Leetcode - daily_temperatures
 */
package com.duol.leetcode.y20.before.daily_temperatures;

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

    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        //反向遍历
        for (int i = T.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < T.length; j += result[j]) { // 跳跃式遍历
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                } else if (result[j] == 0) {
                    // 遇到0表示后面没有更大的
                    result[i] = 0;
                    break;
                }
            }
        }
        return result;
    }

}
