package com.duol.leetcode.y20.before.daily_temperatures;

import java.util.Stack;

/**
 * @author HeJiaGeng
 * @date 2020/1/21
 * @desc 用栈实现
 */
public class Solution3 implements Solution {
    @Override
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            result[i] = 0;
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int t = stack.pop();
                result[t] = i - t;
            }
            stack.push(i);
        }
        return result;
    }
}
