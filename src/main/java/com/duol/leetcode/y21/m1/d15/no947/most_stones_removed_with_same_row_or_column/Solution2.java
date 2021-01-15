/**
 * Leetcode - most_stones_removed_with_same_row_or_column
 */
package com.duol.leetcode.y21.m1.d15.no947.most_stones_removed_with_same_row_or_column;

import java.util.*;

import com.duol.common.*;

/**
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column/solution/yi-chu-zui-duo-de-tong-xing-huo-tong-lie-m50r/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution2 implements Solution {

    public int removeStones(int[][] stones) {
        int n = stones.length;
        List<List<Integer>> edge = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edge.add(new ArrayList<>());
        }

        Map<Integer, List<Integer>> rec = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!rec.containsKey(stones[i][0])) {
                rec.put(stones[i][0], new ArrayList<>());
            }
            rec.get(stones[i][0]).add(i);
            if (!rec.containsKey(stones[i][1] + 10000)) {
                rec.put(stones[i][1] + 10000, new ArrayList<>());
            }
            rec.get(stones[i][1] + 10000).add(i);
        }
        for (Map.Entry<Integer, List<Integer>> entry : rec.entrySet()) {
            List<Integer> list = entry.getValue();
            int k = list.size();
            for (int i = 1; i < k; i++) {
                edge.get(list.get(i - 1)).add(list.get(i));
                edge.get(list.get(i)).add(list.get(i - 1));
            }
        }

        boolean[] vis = new boolean[n];
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                num++;
                dfs(i, edge, vis);
            }
        }
        return n - num;
    }

    public void dfs(int x, List<List<Integer>> edge, boolean[] vis) {
        vis[x] = true;
        for (int y : edge.get(x)) {
            if (!vis[y]) {
                dfs(y, edge, vis);
            }
        }
    }


}
