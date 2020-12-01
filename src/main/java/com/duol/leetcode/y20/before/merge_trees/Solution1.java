/**
 * Leetcode - merge_trees
 */
package com.duol.leetcode.y20.before.merge_trees;

import com.duol.common.TreeNode;

import java.util.*;


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

    public TreeNode mergeTrees(TreeNode para1, TreeNode para2) {
        if (Objects.isNull(para1) && Objects.isNull(para2)) {
            return null;
        }
        if (Objects.isNull(para1)) {
            return para2;
        }
        if (Objects.isNull(para2)) {
            return para1;
        }
        TreeNode newTree = new TreeNode(para1.val + para2.val);
        newTree.left = mergeTrees(para1.left, para2.left);
        newTree.right = mergeTrees(para1.right, para2.right);
        return newTree;
    }

}
