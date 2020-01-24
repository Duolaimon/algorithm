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
import java.util.List;

/**
 * TreeNode is the node of a binary tree.
 *
 * @author Wei SHEN
 */
public class TreeNode {

    /**
     *     val
     *     / \
     *  left right
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
     * @param vals 值
     */
    public static TreeNode newTree(Integer... vals) {
        return newTree(0, vals);
    }

    private static TreeNode newTree(int start, Integer... vals) {
        if (start >= vals.length) {
            return null;
        }
        TreeNode root = new TreeNode(vals[start]);
        root.left = newTree((start + 1) * 2 - 1, vals);
        root.right = newTree((start + 1) * 2, vals);
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
     * @return List of Integer
     *
     * For example, given the following tree,
     *      a
     *     / \
     *    b  null
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
            if (line.isEmpty()) continue;
            for (Integer n : line) { // ignore the bottom line with all null nodes
                if (n != null) res.add(line);
                break;
            }
        }
        return res;
    }

}