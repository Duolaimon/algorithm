/**
 * Leetcode - largest_rectangle_in_histogram
 */
package com.duol.leetcode.y20.m12.d26.no84.largest_rectangle_in_histogram;
import java.util.*;
import com.duol.common.*;

/** 
 * 我们可以遍历每根柱子，以当前柱子 i 的高度作为矩形的高，
 * 那么矩形的宽度边界即为向左找到第一个高度小于当前柱体 i 的柱体，向右找到第一个高度小于当前柱体 i 的柱体。
 *
 * 对于每个柱子我们都如上计算一遍以当前柱子作为高的矩形面积，最终比较出最大的矩形面积即可。
 *
 * 作者：sweetiee
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/xiang-jie-dan-diao-zhan-bi-xu-miao-dong-by-sweetie/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Solution1 implements Solution {

    public int largestRectangleArea(int[] heights) {
        int area = 0, n = heights.length;
        // 遍历每个柱子，以当前柱子的高度作为矩形的高 h，
        // 从当前柱子向左右遍历，找到矩形的宽度 w。
        for (int i = 0; i < n; i++) {
            int w = 1, h = heights[i], j = i;
            while (--j >= 0 && heights[j] >= h) {
                w++;
            }
            j = i;
            while (++j < n && heights[j] >= h) {
                w++;
            }
            area = Math.max(area, w * h);
        }

        return area;
    }

}
