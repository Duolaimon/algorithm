/**
 * Leetcode - sum_nums
 */
package com.duol.leetcode.sum_nums;
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

    public int sumNums(int n){
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

}
