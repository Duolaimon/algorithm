/**
 * Leetcode - sliding_window_median
 */
package com.duol.leetcode.y21.m2.d3.no480.sliding_window_median;

import java.util.*;

import com.duol.common.*;

/**
 *
 */
class Solution2 implements Solution {

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] window = new double[nums.length - k + 1];
        if (nums.length == 0) {
            return new double[0];
        }
        if (nums.length == 1) {
            return new double[]{nums[0]};
        }
        int[] arr = new int[k];
        //先维护一个有序的窗口
        if (k > 0) {
            System.arraycopy(nums, 0, arr, 0, k);
        }
        Arrays.sort(arr);
        //计算k是奇数还是偶数
        boolean even = k % 2 == 0;
        for (int i = k; i <= nums.length; i++) {
            window[i - k] = even ? arr[k / 2] / 2d + arr[k / 2 - 1] / 2d : arr[k / 2];
            if (i == nums.length) {
                continue;
            }
            int in = nums[i];
            int addIndex = findIndex(in, arr);
            int removeIndex = findIndex(nums[i - k], arr);
            //进行插入和移除操作
            if (addIndex == removeIndex) {
                arr[removeIndex] = in;
            } else if (removeIndex < addIndex) {
                //把两个index之间的数移过来不包括addIndex上的数,因为in必定是小于nums[addIndex]的
                if (addIndex - 1 - removeIndex >= 0) {
                    System.arraycopy(arr, removeIndex + 1, arr, removeIndex, addIndex - 1 - removeIndex);
                }
                arr[addIndex - 1] = in;
            } else {
                //右移
                if (removeIndex - addIndex >= 0) {
                    System.arraycopy(arr, addIndex, arr, addIndex + 1, removeIndex - addIndex);
                }
                arr[addIndex] = in;
            }
        }
        return window;
    }


    private int findIndex(int in, int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (arr[mid] < in) {
                left = mid + 1;
            } else if (arr[mid] > in) {
                right = mid - 1;
            } else if (arr[mid] == in) {
                return mid;
            }
        }
        return left;
    }

}
