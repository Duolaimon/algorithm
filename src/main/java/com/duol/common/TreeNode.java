/**
 * MIT License
 * <p>
 * Copyright (c) 2018 Wei SHEN
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.duol.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TreeNode is the node of a binary tree.
 *
 * @author Wei SHEN
 */
public class TreeNode {

    /**
     * val
     * / \
     * left right
     */
    public TreeNode left;
    public TreeNode right;
    public Integer val;

    // create node with a specific value
    public TreeNode(Integer x) {
        val = x;
    }

    /**
     * 层序赋值
     */
    public static TreeNode newTree(Integer[] data) {
        TreeNode root;
        List<TreeNode> list = new ArrayList<>();//新建一个list集合，将数据变为各个节点
        for (Integer tempdata : data) {
            list.add(new TreeNode(tempdata));
        }
        root = list.get(0);//将第一个元素设置为根节点
        /*
         * 利用构建完全二叉树的方式构建
         */
        for (int i = 0; i < list.size() / 2; i++) {
            if ((i * 2 + 1) < list.size()) {
                TreeNode node = list.get(i * 2 + 1);
                list.get(i).left = node.val == null ? null : node;
            }
            if ((i * 2 + 2) < list.size()) {

                list.get(i).right = list.get(i * 2 + 2);
            }
        }
        return root;
    }


    /**
     * Serialization: print the nodes in BFS order
     */
    public String toString() {
        return bfs().toString();
    }


    /**
     * Parse the tree in BFS order
     *
     * @return List of Integer
     * <p>
     * For example, given the following tree,
     * a
     * / \
     * b  null
     * output = [[a],[b,null]]
     * null node will be listed in the output
     */
    private List<List<Integer>> bfs() {
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> buffer = new ArrayList<>();
        buffer.add(this);
        while (!buffer.isEmpty()) {
            List<Integer> line = new ArrayList<>();
            int size = buffer.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = buffer.remove(0);
                if (node == null) {
                    line.add(null);
                } else {
                    line.add(node.val);
                    buffer.add(node.left);
                    buffer.add(node.right);
                }
            }
            if (!line.isEmpty()) {
                for (Integer n : line) { // ignore the bottom line with all null nodes
                    if (n != null) {
                        res.add(line);
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] data = {10, 5, -3, 3, 2, null, 11, 3, -2, null, 1};
        System.out.println(Arrays.toString(data));
        TreeNode root = newTree(data);
        System.out.println(root);
    }

}