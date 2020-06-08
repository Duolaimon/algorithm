/**
 * Leetcode - satisfiability_of_equality_equations
 */
package com.duol.leetcode.satisfiability_of_equality_equations;
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

    public boolean equationsPossible(String[] equations){
        String equal = "==";
        String nonEqual = "!=";
        int[] array = new int[26];
        for (int i = 0; i < 26; i++) {
            array[i] = i;
        }
        for (String equation : equations) {
            char a = equation.charAt(0);
            char b = equation.charAt(3);
            if (equation.contains(equal)) {
                int temp = array[b - 'a'];
                for (int i = 0; i < 26; i++) {
                    if (array[i] == temp) {
                        array[i] = array[a - 'a'];
                    }
                }
            }
        }
        for (String equation : equations) {
            char a = equation.charAt(0);
            char b = equation.charAt(3);
            if (equation.contains(nonEqual)) {
                if (array[b - 'a'] == array[a - 'a']) {
                    return false;
                }
            }
        }
        return true;
    }

}
