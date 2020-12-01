/**
 * Leetcode - count_sub_strings
 */
package com.duol.leetcode.y20.before.count_sub_strings;

/**
 * 动态规划
 */
class Solution1 implements Solution {

    public int countSubstrings(String para1) {
        boolean[][] dp = new boolean[para1.length()][para1.length()];
        int result = 0;
        for (int i = 0; i < para1.length(); i++) {
            //i长度
            for (int j = 0; j < para1.length() - i; j++) {
                //j初始位置
                if (para1.charAt(j) == para1.charAt(j + i) && (i <= 2 || dp[j + 1][j + i - 1])) {
                    /*两个字符相等，是回文的可能:
                        1.距离不大于2
                        2.距离大于2，两个字符之间子串是回文
                     */
                    dp[j][j + i] = true;
                    result++;
                }
            }
        }
        return result;
    }

}
