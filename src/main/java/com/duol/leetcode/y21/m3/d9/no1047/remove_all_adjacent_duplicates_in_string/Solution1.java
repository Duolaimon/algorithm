/**
 * Leetcode - remove_all_adjacent_duplicates_in_string
 */
package com.duol.leetcode.y21.m3.d9.no1047.remove_all_adjacent_duplicates_in_string;

import java.util.*;

import com.duol.common.*;

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

    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        int index = stack.size() - 1;
        char[] res = new char[stack.size()];
        while (!stack.isEmpty()) {
            res[index--] = stack.pop();
        }
        return new String(res);
    }

}
