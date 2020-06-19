/**
 * Leetcode - recover_a_tree_from_preorder_traversal
 */
package com.duol.leetcode.recover_a_tree_from_preorder_traversal;

import java.util.*;

import com.duol.common.*;

/**
 * todo 未写完
 */
class Solution1 implements Solution {
    private static final String BASE_SPLIT = "-";

    public TreeNode recoverFromPreorder(String S) {
        int i = S.indexOf(BASE_SPLIT);
        TreeNode root = new TreeNode(Integer.parseInt(S.substring(0, i)));
        return null;
    }

    public TreeNode recover(String S, int layer) {
        StringBuilder split = new StringBuilder();
        for (int i = 0; i < layer; i++) {
            split.append(BASE_SPLIT);
        }
        int first = S.indexOf(split.toString());
        int two = S.indexOf(split.toString(), first + 1);
        return null;
    }

}
