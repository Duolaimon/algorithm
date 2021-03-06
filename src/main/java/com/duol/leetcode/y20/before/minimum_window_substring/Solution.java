/**
* Leetcode - minimum_window_substring
*/
package com.duol.leetcode.y20.before.minimum_window_substring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * No.76
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 */
interface Solution {

// use this Object to print the log (call from slf4j facade)
static Logger log = LoggerFactory.getLogger(Solution.class);

    String minWindow(String s, String t);
}
