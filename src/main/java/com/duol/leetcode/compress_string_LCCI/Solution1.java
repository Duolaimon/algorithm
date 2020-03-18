/**
 * Leetcode - compress_string_LCCI
 */
package com.duol.leetcode.compress_string_LCCI;

import java.util.*;

import com.duol.common.*;

/**
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution1 implements Solution {

    public String compressString(String S) {
        if (S.length() == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        char currentChar = S.charAt(0);
        int currentNum = 1;
        for (int i = 1; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == currentChar) {
                currentNum++;
            } else {
                result.append(currentChar).append(currentNum);
                currentChar = c;
                currentNum = 1;
            }
        }
        result.append(currentChar).append(currentNum);
        return result.length() >= S.length() ? S : result.toString();
    }

}
