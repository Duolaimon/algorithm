/**
 * Leetcode - binary_tree_zigzag_level_order_traversal
 */
package com.duol.leetcode.y20.m12.d22.no103.binary_tree_zigzag_level_order_traversal;

import java.util.*;

import com.duol.common.*;

/**
 * 方法一：广度优先遍历
 * 此题是「102. 二叉树的层序遍历」的变种，最后输出的要求有所变化，要求我们按层数的奇偶来决定每一层的输出顺序。规定二叉树的根节点为第 00 层，如果当前层数是偶数，从左至右输出当前层的节点值，否则，从右至左输出当前层的节点值。
 *
 * 我们依然可以沿用第 102 题的思想，修改广度优先搜索，对树进行逐层遍历，用队列维护当前层的所有元素，当队列不为空的时候，求得当前队列的长度 \textit{size}size，每次从队列中取出 \textit{size}size 个元素进行拓展，然后进行下一次迭代。
 *
 * 为了满足题目要求的返回值为「先从左往右，再从右往左」交替输出的锯齿形，我们可以利用「双端队列」的数据结构来维护当前层节点值输出的顺序。
 *
 * 双端队列是一个可以在队列任意一端插入元素的队列。在广度优先搜索遍历当前层节点拓展下一层节点的时候我们仍然从左往右按顺序拓展，但是对当前层节点的存储我们维护一个变量 \textit{isOrderLeft}isOrderLeft 记录是从左至右还是从右至左的：
 *
 * 如果从左至右，我们每次将被遍历到的元素插入至双端队列的末尾。
 *
 * 如果从右至左，我们每次将被遍历到的元素插入至双端队列的头部。
 *
 * 当遍历结束的时候我们就得到了答案数组。
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/solution/er-cha-shu-de-ju-chi-xing-ceng-xu-bian-l-qsun/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution2 implements Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<>(levelList));
            isOrderLeft = !isOrderLeft;
        }

        return ans;
    }
}
