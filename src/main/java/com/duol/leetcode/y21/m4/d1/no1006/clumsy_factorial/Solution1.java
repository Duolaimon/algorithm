/**
 * Leetcode - clumsy_factorial
 */
package com.duol.leetcode.y21.m4.d1.no1006.clumsy_factorial;

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

    public int clumsy(int N) {
        int ope = 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(N);
        for (int i = N - 1; i > 0; i--) {
            switch (ope) {
                case 0:
                    stack.push(stack.pop() * i);
                    break;
                case 1:
                    stack.push(stack.pop() / i);
                    break;
                case 2:
                    stack.push(i);
                    break;
                case 3:
                    stack.push(-i);
                    break;
                default:
                    break;
            }
            ope = (ope + 1) % 4;
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

}
