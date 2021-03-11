/**
* Leetcode - basic_calculator
*/
package com.duol.leetcode.y21.m3.d10.no224.basic_calculator;
import java.util.*;
import com.duol.common.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 224. 基本计算器
 *
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 *
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 *
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 * 
 *
 * 提示：
 *
 * 1 <= s.length <= 3* 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
interface Solution {

// use this Object to print the log (call from slf4j facade)
static Logger log = LoggerFactory.getLogger(Solution.class);

    int calculate(String s);
}
