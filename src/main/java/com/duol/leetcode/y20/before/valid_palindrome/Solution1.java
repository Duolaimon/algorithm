/**
 * Leetcode - valid_palindrome
 */
package com.duol.leetcode.y20.before.valid_palindrome;
import java.util.*;

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

    public boolean isPalindrome(String s){
        String result = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int l = 0, r = result.length() - 1;
        while (l < r) {
            if (!Objects.equals(result.charAt(l), result.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
