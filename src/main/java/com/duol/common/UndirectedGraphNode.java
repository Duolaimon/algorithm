/**
 * MIT License
 *
 * Copyright (c) 2018 Wei SHEN 

 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.

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
 * Visually, a graph looks like the following:
 *     1
 *    / \
 *   /   \
 *  0 --- 2
 *       / \
 *       \_/
 * 
 * Each node in the graph contains a label (int) and 
 * a list (List[UndirectedGraphNode]) of its neighbors. 
 * There is an edge between the given node and each of 
 * the nodes in its neighbors.
 * 
 * Related problems
 * #133 - Clone Graph
 * 
 * @author Wei SHEN
 */
public class UndirectedGraphNode {

    public int label;
    public List<com.ciaoshen.leetcode.util.UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<com.ciaoshen.leetcode.util.UndirectedGraphNode>();
    }

}
