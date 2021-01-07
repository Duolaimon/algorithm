package com.duol.leetcode.y21.m1.d7.no547.number_of_provinces;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 作者：sweetiee
 * 链接：https://leetcode-cn.com/problems/number-of-provinces/solution/dfs-bfs-bing-cha-ji-3-chong-fang-fa-ji-s-edkl/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * 广度优先遍历
 */
public class Solution3 implements Solution {

    public int findCircleNum(int[][] isConnected) {
        // int[][] isConnected 是无向图的邻接矩阵，n 为无向图的顶点数量
        int n = isConnected.length;
        // 定义 boolean 数组标识顶点是否被访问
        boolean[] visited = new boolean[n];

        // 定义 cnt 来累计遍历过的连通域的数量
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // 若当前顶点 i 未被访问，说明又是一个新的连通域，则bfs新的连通域且cnt+=1.
            if (!visited[i]) {
                cnt++;
                queue.offer(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    int v = queue.poll();
                    for (int w = 0; w < n; w++) {
                        if (isConnected[v][w] == 1 && !visited[w]) {
                            visited[w] = true;
                            queue.offer(w);
                        }
                    }
                }
            }
        }
        return cnt;
    }

}
