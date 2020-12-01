/**
 * Leetcode - reorganize_string
 */
package com.duol.leetcode.y20.before.reorganize_string;

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

    public String reorganizeString(String para1) {
        int length = para1.length();
        if (length == 1)
            return para1;
        int[] arr = new int[26];
        int maxLength = 0;

        for (char c : para1.toCharArray()) {
            if (maxLength < ++arr[c - 'a'])
                maxLength = arr[c - 'a'];
        }

        if (maxLength > (length + 1) / 2)
            return "";

        char[] ret = new char[para1.length()];
        int even = 0, odd = 1;
        for (int i = 0; i < 26; i++) {
            while (arr[i] > 0 && arr[i] < (length / 2 + 1) && odd < length) {
                ret[odd] = (char) (i + 'a');
                arr[i]--;
                odd += 2;
            }
            while (arr[i] > 0) {
                ret[even] = (char) (i + 'a');
                arr[i]--;
                even += 2;
            }
        }
        return new String(ret);
    }

}
