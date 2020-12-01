/**
 * Leetcode - reorganize_string
 */
package com.duol.leetcode.y20.before.reorganize_string;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * No.767
 * <p>
 * Given a string S, check if the letters can be rearranged
 * so that two characters that are adjacent to each other are not the same.
 * <p>
 * If possible, output any possible result.  If not possible, return the empty string.
 * Example 1:
 * <p>
 * Input: S = "aab"
 * Output: "aba"
 * Example 2:
 * <p>
 * Input: S = "aaab"
 * Output: ""
 * Note:
 * <p>
 * S will consist of lowercase letters and have length in range [1, 500].
 */
interface Solution {

    // use this Object to print the log (call from slf4j facade)
    static Logger log = LoggerFactory.getLogger(Solution.class);

    String reorganizeString(String para1);
}
