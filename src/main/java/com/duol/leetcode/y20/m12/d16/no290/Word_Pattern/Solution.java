/**
* Leetcode - word_pattern
*/
package com.duol.leetcode.y20.m12.d16.no290.word_pattern;
import java.util.*;
import com.duol.common.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 290. 单词规律
 *
 * 给定一种规律 pattern和一个字符串str，判断 str 是否遵循相同的规律。
 *
 * 这里的遵循指完全匹配，例如，pattern里的每个字母和字符串str中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设pattern只包含小写字母，str包含了由单个空格分隔的小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
interface Solution {

// use this Object to print the log (call from slf4j facade)
static Logger log = LoggerFactory.getLogger(Solution.class);

    boolean wordPattern(String pattern, String s);
}
