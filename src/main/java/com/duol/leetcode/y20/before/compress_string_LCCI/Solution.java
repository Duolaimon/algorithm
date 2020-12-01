/**
* Leetcode - compress_string_LCCI
*/
package com.duol.leetcode.y20.before.compress_string_LCCI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 01.06
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2blc5a3.
 * If the "compressed" string would not become smaller than the original string, your method should return the original string.
 * You can assume the string has only uppercase and lowercase letters (a - z).
 *
 * Example 1:
 *
 * Input: "aabcccccaaa"
 * Output: "a2b1c5a3"
 * Example 2:
 *
 * Input: "abbccd"
 * Output: "abbccd"
 * Explanation:
 * The compressed string is "a1b2c2d1", which is longer than the original string.
 *  
 *
 * Note:
 *
 * 0 <= S.length <= 50000
 *
 */
interface Solution {

// use this Object to print the log (call from slf4j facade)
static Logger log = LoggerFactory.getLogger(Solution.class);

    String compressString(String S);
}
