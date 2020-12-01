/**
 * Leetcode - recover_a_tree_from_preorder_traversal
 */
package com.duol.leetcode.y20.before.recover_a_tree_from_preorder_traversal;

import com.duol.common.*;

/**
 * todo 未写完
 */
class Solution1 implements Solution {
    private static final String BASE_SPLIT = "-";

    public TreeNode recoverFromPreorder(String S) {
        return dfs(S.toCharArray(), new int[]{0}, 0);
    }

    /**
     * @param chs   字符数组
     * @param i     i[0]表示当前开始数组位置
     * @param level 层，顶层为0
     */
    private TreeNode dfs(char[] chs, int[] i, int level) {
        if (i[0] == chs.length) {
            return null;
        }
        //分隔符'-'个数
        int c = 0;
        int j = i[0];
        while (chs[j] == '-') {
            j++;
            c++;
        }
        //'-'个数与层数不等，该值不属于当前层
        if (c != level) {
            return null;
        }
        //拿到数值
        int num = 0;
        while (j < chs.length && chs[j] != '-') {
            num = num * 10 + (chs[j] - '0');
            j++;
        }
        TreeNode root = new TreeNode(num);
        i[0] = j;
        //递归左右节点
        root.left = dfs(chs, i, level + 1);
        root.right = dfs(chs, i, level + 1);
        return root;
    }

}
