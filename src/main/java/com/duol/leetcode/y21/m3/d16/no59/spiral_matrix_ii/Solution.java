/**
* Leetcode - spiral_matrix_ii
*/
package com.duol.leetcode.y21.m3.d16.no59.spiral_matrix_ii;
import java.util.*;
import com.duol.common.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 59. 螺旋矩阵 II
 * 
 * 给你一个正整数n ，生成一个包含 1 到n2所有元素，且元素按顺时针顺序螺旋排列的n x n 正方形矩阵 matrix 。
 *
 * 
 *
 * 示例 1：
 *
 *
 * 输入：n = 3
 * 输出：[
 *  [1,2,3],
 *  [8,9,4],
 *  [7,6,5]
 *  ]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 * 
 *
 * 提示：
 *
 * 1 <= n <= 20
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
interface Solution {

// use this Object to print the log (call from slf4j facade)
static Logger log = LoggerFactory.getLogger(Solution.class);

    int[][] generateMatrix(int n);
}
