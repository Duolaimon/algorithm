/**
* Leetcode - largest_rectangle_in_histogram
*/
package com.duol.leetcode.y20.m12.d26.no84.largest_rectangle_in_histogram;
import java.util.*;
import com.duol.common.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 84. 柱状图中最大的矩形
 *
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
interface Solution {

// use this Object to print the log (call from slf4j facade)
static Logger log = LoggerFactory.getLogger(Solution.class);

    int largestRectangleArea(int[] heights);
}
