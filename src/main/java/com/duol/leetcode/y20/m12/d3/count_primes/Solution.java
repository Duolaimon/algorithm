/**
* Leetcode - count_primes
*/
package com.duol.leetcode.y20.m12.d3.count_primes;
import java.util.*;
import com.duol.common.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 204. 计数质数
 *
 * 统计所有小于非负整数n的质数的数量。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：0
 * 
 *
 * 提示：
 *
 * 0 <= n <= 5 * 10^6
 */
interface Solution {

// use this Object to print the log (call from slf4j facade)
static Logger log = LoggerFactory.getLogger(Solution.class);

    int countPrimes(int n);
}
