/**
 * Leetcode - isomorphic_strings
 */
package com.duol.leetcode.y20.m12.d27.no205.isomorphic_strings;
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

    public boolean isIsomorphic(String s, String t) {
        int sm[] = new int[128];
        int tm[] = new int[128];
        char sc[] = s.toCharArray();
        char tc[] = t.toCharArray();
        for(int i=0; i<s.length(); i++){
            if(sm[sc[i]] != tm[tc[i]])
                return false;
            sm[sc[i]] = tm[tc[i]] = i+1;
        }
        return true;
    }

}
