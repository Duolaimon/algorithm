/**
 * Leetcode - count_sub_strings
 */
package com.duol.leetcode.y20.before.count_sub_strings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * No.647
 * <p>
 * Given a string, your task is to count how many palindromic substrings in this string.
 * <p>
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 */
interface Solution {

    // use this Object to print the log (call from slf4j facade)
    static Logger log = LoggerFactory.getLogger(Solution.class);

    int countSubstrings(String para1);
}
