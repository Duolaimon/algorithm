/**
 * Leetcode - subsets_ii
 */
package com.duol.leetcode.y21.m3.d31.no90.subsets_ii;
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
class Solution1 implements Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums){
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        int n = nums.length;
        List<Integer> cur = new ArrayList<>(n);
        for (int i = 0; i < (1 << n); i++) {
            // 2 ^ n种可能，以2进制形式表示每种可能性
            cur.clear();
            // 对每一种可能性收集，检测可能性中每一位，为1则表示当前可能性包含这个位置的数
            for (int j = 0; j < n; j++) {
                int t = (i >> j) & 1;
                if (t == 1) {
                    cur.add(nums[j]);
                }
            }
            // 通过set去重
            res.add(new ArrayList<>(cur));
        }
        return new ArrayList<>(res);
    }

}
