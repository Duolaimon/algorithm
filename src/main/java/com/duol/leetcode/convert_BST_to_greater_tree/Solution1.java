/**
 * Leetcode - convert_BST_to_greater_tree
 */
package com.duol.leetcode.convert_BST_to_greater_tree;
import java.util.*;
import com.duol.common.*;

/** 
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution1 implements Solution {

    public TreeNode convertBST(TreeNode root){
        increase(root, 0);
        return root;
    }

    public int increase(TreeNode root, int num) {
        if (root == null) {
            return num;
        }
        num = increase(root.right, num);
        root.val = root.val + num;
        if (root.left == null) {
            return root.val;
        }
        return increase(root.left, root.val);
    }

}
