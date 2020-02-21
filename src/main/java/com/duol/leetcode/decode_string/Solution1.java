/**
 * Leetcode - decode_string
 */
package com.duol.leetcode.decode_string;

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

    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                stack.push(String.valueOf(s.charAt(i)));
            } else {
                StringBuilder sb = new StringBuilder();
                while (!(stack.peek()).equals("[")) {
                    sb.insert(0, stack.pop());
                }
                stack.pop();
                StringBuilder sb3 = new StringBuilder();
                while (!stack.isEmpty() && stack.peek().length() <= 1 && stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9') {
                    sb3.insert(0, stack.pop());
                }
                int time = Integer.parseInt(sb3.toString());
                StringBuilder sb2 = new StringBuilder();
                for (int j = 0; j < time; j++) {
                    sb2.append(sb.toString());
                }
                stack.push(sb2.toString());
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

}
