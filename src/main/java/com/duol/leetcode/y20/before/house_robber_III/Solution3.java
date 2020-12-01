package com.duol.leetcode.y20.before.house_robber_III;

import com.duol.common.TreeNode;

/**
 * @author HeJiaGeng
 * @date 2020/3/18
 * @desc
 */
public class Solution3 implements Solution {
    @Override
    public int rob(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robInternal(TreeNode root) {
        if (root == null) return new int[2];
        int[] result = new int[2];

        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;
    }
}
