package com.duol.leetcode.y20.before.count_sub_strings;

/**
 * @author HeJiaGeng
 * @date 2020/1/22
 * @desc
 */
public class Solution4 implements Solution {
    @Override
    public int countSubstrings(String para1) {
        int total = 0;
        for (int i = 0; i < para1.length(); i++) {
            total += count(para1, i, i);
            total += count(para1, i, i + 1);
        }
        return total;
    }

    private int count(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start--) == s.charAt(end++)) {
            count++;
        }
        return count;
    }
}
