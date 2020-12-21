/**
 * Leetcode - remove_duplicate_letters
 */
package com.duol.leetcode.y20.m12.d20.no316.remove_duplicate_letters;

import java.util.*;

import com.duol.common.*;

/**
 *
 */
class Solution1 implements Solution {

    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.contains(c)) {
                while (!stack.isEmpty() && c < stack.peek() && map.get(stack.peek()) > 0) {
                    stack.pop();
                }
                stack.push(c);
            }
            map.put(c, map.get(c) - 1);
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

}
