/**
 * Leetcode - sort_items_by_groups_respecting_dependencies
 */
package com.duol.leetcode.y21.m1.d12.no1203.sort_items_by_groups_respecting_dependencies;
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
class Solution2 implements Solution {

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) group[i] = m++;
        }
        List<Integer>[] groupEdges = new List[m];
        List<Integer>[] itemEdges  = new List[n];
        int[] groupDegree = new int[m];
        int[] itemDegree  = new int[n];
        for (int i = 0; i < beforeItems.size(); i++) {
            List<Integer> list = beforeItems.get(i);
            for (int k : list) {
                if (group[k] == group[i]) {
                    itemDegree[i]++;
                    if (itemEdges[k] == null) itemEdges[k] = new ArrayList<>();
                    itemEdges[k].add(i);
                } else {
                    groupDegree[group[i]]++;
                    if (groupEdges[group[k]] == null) groupEdges[group[k]] = new ArrayList<>();
                    groupEdges[group[k]].add(group[i]);
                }
            }
        }
        int[] groups = new int[m];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if (groupDegree[i] == 0) queue.add(i);
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int i = queue.poll();
            groups[index++] = i;
            if (groupEdges[i] == null) continue;
            for (int j = 0; j < groupEdges[i].size(); j++) {
                if (--groupDegree[groupEdges[i].get(j)] == 0) queue.add(groupEdges[i].get(j));
            }

        }
        if (index < m) return new int[0];

        List<Integer>[] groupMembers = new List[m];
        for (int i = 0; i < n; i++) {
            if (groupMembers[group[i]] == null) groupMembers[group[i]] = new ArrayList<>();
            groupMembers[group[i]].add(i);
        }

        int[] res = new int[n];
        index = 0;
        for (int i = 0; i < m; i++) {
            int g = groups[i];
            if (groupMembers[g] == null) continue;
            for (int j = 0; j < groupMembers[g].size(); j++) {
                if (itemDegree[groupMembers[g].get(j)] == 0) queue.add(groupMembers[g].get(j));
            }
            int c = 0;
            while (!queue.isEmpty()) {
                int j = queue.poll();
                res[index++] = j;
                ++c;
                if (itemEdges[j] == null) continue;
                for (int k = 0; k < itemEdges[j].size();k++) {
                    if (--itemDegree[itemEdges[j].get(k)] == 0) queue.add(itemEdges[j].get(k));
                }
            }
            if (c != groupMembers[g].size()) return new int[0];
        }
        return res;
    }

}
