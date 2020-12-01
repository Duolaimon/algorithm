/**
 * Leetcode - reorganize_string
 */
package com.duol.leetcode.y20.before.reorganize_string;

import java.util.*;

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

    public String reorganizeString(String para1) {
        int N = para1.length();
        int[] counts = new int[26];
        for (char c : para1.toCharArray()) {
            counts[c - 'a'] += 100;
        }
        for (int i = 0; i < 26; ++i) {
            counts[i] += i;
        }
        //Encoded counts[i] = 100*(actual count) + (i)
        Arrays.sort(counts);

        char[] ans = new char[N];
        int t = 1;
        for (int code : counts) {
            int ct = code / 100;
            char ch = (char) ('a' + (code % 100));
            if (ct > (N + 1) / 2) {
                return "";
            }
            for (int i = 0; i < ct; ++i) {
                if (t >= N) {
                    t = 0;
                }
                ans[t] = ch;
                t += 2;
            }
        }
        return String.valueOf(ans);
    }

}
