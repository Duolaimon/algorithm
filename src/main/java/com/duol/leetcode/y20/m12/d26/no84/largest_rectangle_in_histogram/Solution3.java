package com.duol.leetcode.y20.m12.d26.no84.largest_rectangle_in_histogram;

/**
 * @author HeJiaGeng
 * @date 2020/12/26
 * @desc
 */
public class Solution3 implements Solution {
    public int largestRectangleArea(int[] heights) {
        return maxArea(heights, 0, heights.length - 1);
    }

    public int maxArea(int[] heights, int left, int right) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            return heights[left];
        }
        int minIndex = left;
        int minHeight = heights[left];
        // 判断是否有序，且记录最小高度
        boolean ordered = true;
        for (int i = left + 1; i <= right; i++) {
            if (ordered) {
                if (heights[i] >= heights[i - 1]) {
                    continue;
                } else {
                    ordered = false;
                }
            }
            if (heights[i] < minHeight) {
                minIndex = i;
                minHeight = heights[i];
            }
        }
        // 有序
        if (ordered) {
            int width = right - left + 1;
            int maxArea = 0;
            for (int i = left; i <= right; i++) {
                maxArea = Math.max(maxArea, width * heights[i]);
                width--;
            }
            return maxArea;
        }
        // 无序
        return Math.max(
                minHeight * (right - left + 1), Math.max(
                        maxArea(heights, left, minIndex - 1),
                        maxArea(heights, minIndex + 1, right)
                )
        );
    }
}
