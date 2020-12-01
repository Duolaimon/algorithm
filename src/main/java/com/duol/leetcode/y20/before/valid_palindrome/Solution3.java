package com.duol.leetcode.y20.before.valid_palindrome;

/**
 * @author HeJiaGeng
 * @date 2020/6/19
 * @desc
 */
public class Solution3 implements Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!isChar(s.charAt(left))) {
                left++;
            } else if (!isChar(s.charAt(right))) {
                right--;
            } else if ((s.charAt(left) + 32 - 'a') % 32 != (s.charAt(right) + 32 - 'a') % 32) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public boolean isChar(char c) {
        if ('0' <= c && c <= '9') return true;
        if ('a' <= c && c <= 'z') return true;
        if ('A' <= c && c <= 'Z') return true;
        return false;
    }
}
