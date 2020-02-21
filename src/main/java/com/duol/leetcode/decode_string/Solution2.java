/**
 * Leetcode - decode_string
 */
package com.duol.leetcode.decode_string;

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
class Solution2 implements Solution {

    int i = 0;

    public String decodeString(String s) {
        int len = s.length();
        if (len < 1) return "";
        char[] cs = s.toCharArray();
        StringBuilder sb = new StringBuilder("");
        while (i < len) {
            int times = 0;
            //get times
            while (i < len && cs[i] <= '9') {
                times = times * 10 + cs[i] - '0';
                i++;
            }
            //get word
            if (cs[i] == '[') {
                i++;
                String word = decodeString(s);
                while (times > 0) {
                    times--;
                    sb.append(word);
                }
            } else if (cs[i] == ']') {    //reach end
                i++;
                return sb.toString();
            } else {                    //building word
                sb.append(cs[i]);
                i++;
            }
        }
        return sb.toString();
    }

}
