/**
 * Leetcode - diameter_of_binary_tree
 */
package com.duol.leetcode.y20.before.diameter_of_binary_tree;

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

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] max = new int[1];
        return Math.max(highest(root.left, max) + highest(root.right, max), max[0]);
    }


    private int highest(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int leftHighest = highest(root.left, max);
        int rightHighest = highest(root.right, max);
        if (leftHighest + rightHighest > max[0]) {
            max[0] = leftHighest + rightHighest;
        }
        return Math.max(leftHighest, rightHighest) + 1;
    }

}
