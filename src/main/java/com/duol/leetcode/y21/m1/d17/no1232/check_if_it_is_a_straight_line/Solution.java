/**
* Leetcode - check_if_it_is_a_straight_line
*/
package com.duol.leetcode.y21.m1.d17.no1232.check_if_it_is_a_straight_line;
import java.util.*;
import com.duol.common.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 在一个XY 坐标系中有一些点，我们用数组coordinates来分别记录它们的坐标，
 * 其中coordinates[i] = [x, y]表示横坐标为 x、纵坐标为 y的点。
 *
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 *
 * 
 *
 * 示例 1：
 *
 *
 *
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出：true
 * 示例 2：
 *
 *
 *
 * 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * 输出：false
 * 
 *
 * 提示：
 *
 * 2 <=coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <=coordinates[i][0],coordinates[i][1] <= 10^4
 * coordinates中不含重复的点
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-it-is-a-straight-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
interface Solution {

// use this Object to print the log (call from slf4j facade)
static Logger log = LoggerFactory.getLogger(Solution.class);

    boolean checkStraightLine(int[][] coordinates);
}
