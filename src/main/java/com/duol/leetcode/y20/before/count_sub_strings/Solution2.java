/**
 * Leetcode - count_sub_strings
 */
package com.duol.leetcode.y20.before.count_sub_strings;

/**
 * 中心扩散
 * 思路
 *
 * 在长度为 N 的字符串中，可能的回文串中心位置有 2N-1 个：字母，或两个字母中间。
 *
 * 从每一个回文串中心开始统计回文串数量。回文区间 [a, b] 表示 S[a], S[a+1], ..., S[b] 是回文串，
 * 根据回文串定义可知 [a+1, b-1] 也是回文区间。
 *
 * 算法
 *
 * 对于每个可能的回文串中心位置，尽可能扩大它的回文区间 [left, right]。
 * 当 left >= 0 and right < N and S[left] == S[right] 时，扩大区间。
 * 此时回文区间表示的回文串为 S[left], S[left+1], ..., S[right]。
 *
 */
class Solution2 implements Solution {

    public int countSubstrings(String para1) {
        int result = 0;
        for (int i = 0; i < 2 * para1.length() - 1; i++) {
            int left = i / 2;
            int right = left + i % 2;
            while (left >= 0 && right < para1.length() && para1.charAt(left) == para1.charAt(right)) {
                left--;
                right++;
                result++;
            }
        }
        return result;
    }

}
