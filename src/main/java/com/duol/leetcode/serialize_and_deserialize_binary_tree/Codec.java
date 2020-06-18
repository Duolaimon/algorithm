package com.duol.leetcode.serialize_and_deserialize_binary_tree;

import com.duol.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 297.二叉树的序列化与反序列化
 *
 * @author HeJiaGeng
 * @date 2020/6/16
 * @desc Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 * <p>
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 示例: 
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[null]";
        }
        StringBuilder result = new StringBuilder("[");
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            List<Integer> line = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                if (node == null) {
                    line.add(null);
                } else {
                    line.add(node.val);
                    queue.addLast(node.left);
                    queue.addLast(node.right);
                }
            }
            StringBuilder sb = new StringBuilder();
            boolean allNull = true;
            for (Integer l : line) {
                if (l == null) {
                    sb.append("null,");
                } else {
                    sb.append(l).append(",");
                    allNull = false;
                }
            }
            if (!allNull) {
                result.append(sb);
            }
        }
        return result.substring(0, result.length() - 1) + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] datas = data.substring(1, data.length() - 1).split(",");
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(datas[index++]));
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int length = queue.size() * 2;
            for (int i = 0; i < length; i++) {
// todo 2020/6/16
            }
            TreeNode treeNode = queue.pollFirst();
        }
        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode node = TreeNode.newTree(new Integer[]{1, 2, 3, null, null, 4, 5});
        System.out.println(node.toString());
        String serialize = codec.serialize(node);
        System.out.println(serialize);
    }
}
