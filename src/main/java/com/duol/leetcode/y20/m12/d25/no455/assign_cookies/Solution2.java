/**
 * Leetcode - assign_cookies
 */
package com.duol.leetcode.y20.m12.d25.no455.assign_cookies;
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

    public int findContentChildren(int[] g, int[] s) {
        //先对胃口值和饼干尺寸进行排序
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int i = s.length - 1;
        for (int j = g.length - 1; i >= 0 && j >= 0; j--) {
            //如果当前饼干能满足当前孩子的胃口值，count就加1，否则就继续查找胃口更小的孩子
            if (g[j] <= s[i]) {
                count++;
                i--;
            }
        }
        return count;
    }

}
