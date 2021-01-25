/**
 * Leetcode - regions_cut_by_slashes
 */
package com.duol.leetcode.y21.m1.d25.no959.regions_cut_by_slashes;

import java.util.*;

import com.duol.common.*;

/**
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/regions-cut-by-slashes/solution/you-xie-gang-hua-fen-qu-yu-by-leetcode-s-ztob/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution1 implements Solution {

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[] f = new int[n * n * 4];
        for (int i = 0; i < n * n * 4; i++) {
            f[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                if (i < n - 1) {
                    int bottom = idx + n;
                    merge(f, idx * 4 + 2, bottom * 4);
                }
                if (j < n - 1) {
                    int right = idx + 1;
                    merge(f, idx * 4 + 1, right * 4 + 3);
                }
                if (grid[i].charAt(j) == '/') {
                    merge(f, idx * 4, idx * 4 + 3);
                    merge(f, idx * 4 + 1, idx * 4 + 2);
                } else if (grid[i].charAt(j) == '\\') {
                    merge(f, idx * 4, idx * 4 + 1);
                    merge(f, idx * 4 + 2, idx * 4 + 3);
                } else {
                    merge(f, idx * 4, idx * 4 + 1);
                    merge(f, idx * 4 + 1, idx * 4 + 2);
                    merge(f, idx * 4 + 2, idx * 4 + 3);
                }
            }
        }

        Set<Integer> fathers = new HashSet<>();
        for (int i = 0; i < n * n * 4; i++) {
            int fa = find(f, i);
            fathers.add(fa);
        }
        return fathers.size();
    }

    public int find(int[] f, int x) {
        if (f[x] == x) {
            return x;
        }
        int fa = find(f, f[x]);
        f[x] = fa;
        return fa;
    }

    public void merge(int[] f, int x, int y) {
        int fx = find(f, x);
        int fy = find(f, y);
        f[fx] = fy;
    }

}
