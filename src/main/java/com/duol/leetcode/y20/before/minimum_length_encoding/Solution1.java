/**
 * Leetcode - minimum_length_encoding
 */
package com.duol.leetcode.y20.before.minimum_length_encoding;
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

    public int minimumLengthEncoding(String[] words){
        StringBuilder S = new StringBuilder();
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        for (String word : words) {
            if (!S.toString().contains(word + "#")) {
                S.append(word).append("#");
            }
        }
        return S.length();
    }

}
