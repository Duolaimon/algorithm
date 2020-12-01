/**
 * Leetcode - a.to.i
 */
package com.duol.leetcode.y20.before.a.to.i;

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
    private static final int MIN_VALUE = 0x80000000;
    private static final int MAX_VALUE = 0x7fffffff;

    public int myAtoi(String str) {
        str = str.replaceAll(" ", "");
        if (str.isEmpty()) {
            return 0;
        }
        char[] chars = str.toCharArray();
        boolean positive = true;
        boolean hasOne = false;
        if (chars[0] < '0' || chars[0] > '9') {
            if (chars[0] == '-') {
                positive = false;
            } else if (chars[0] == '+') {
                positive = true;
            } else {
                return 0;
            }
            hasOne = true;
        }
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if (hasOne && i == 0) {
                continue;
            }
            if (chars[i] >= '0' && chars[i] <= '9') {
                if (result >= (MAX_VALUE - (chars[i] - '0')) / 10) {
                    return positive ? MAX_VALUE : MIN_VALUE;
                }
                result = result * 10 + chars[i] - '0';
            } else {
                break;
            }
        }
        return positive ? result : -result;
    }

}
