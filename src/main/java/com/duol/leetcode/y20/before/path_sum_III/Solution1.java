/**
 * Leetcode - path_sum_III
 */
package com.duol.leetcode.y20.before.path_sum_III;

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

    public int pathSum(TreeNode root, int sum) {
        int result = 0;
        int index = 1;
        Stack<Object[]> stack = new Stack<>();
        stack.push(new Object[]{root, index});
        int[] array = new int[1001];
        while (!stack.isEmpty()) {
            Object[] objects = stack.pop();
            TreeNode node = (TreeNode) objects[0];
            index = (int) objects[1];
            if (node == null) {
                continue;
            }
            array[index] = node.val;
            stack.push(new Object[]{node.left, index + 1});
            stack.push(new Object[]{node.right, index + 1});
            int n = 0;
            for (int i = index; i > 0; i--) {
                n += array[i];
                if (n == sum) {
                    result++;
                }
            }
        }
        return result;
    }

}
