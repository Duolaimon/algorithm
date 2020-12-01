/**
 * Leetcode - valid_palindrome
 */
package com.duol.leetcode.y20.before.valid_palindrome;

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

    public boolean isPalindrome(String s){
        String result = s.toLowerCase();
        int l = 0, r = result.length() - 1;
        while (l < r) {
            char lc = result.charAt(l);
            while (!isValidChar(lc)) {
                l++;
                if (l >= r) {
                    break;
                }
                lc = result.charAt(l);
            }
            char rc = result.charAt(r);
            while (!isValidChar(rc)) {
                r--;
                if (l >= r) {
                    break;
                }
                rc = result.charAt(r);
            }
            if (lc != rc) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidChar(char a) {
        return (a >= 'a' && a <= 'z') || (a >= '0' && a <= '9');
    }

}
