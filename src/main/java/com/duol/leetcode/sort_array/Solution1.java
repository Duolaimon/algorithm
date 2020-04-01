/**
 * Leetcode - sort_array
 */
package com.duol.leetcode.sort_array;

import java.util.*;

import com.duol.common.*;

/**
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution1 implements Solution {

    public int[] sortArray(int[] nums) {
        return sortArray(nums, 0, nums.length);
    }

    private int[] sortArray(int[] nums, int x, int y) {
        if (x + 1 == y) {
            return new int[]{nums[x]};
        }
        int mid = (x + y) / 2;
        return merge(sortArray(nums, x, mid), sortArray(nums, mid, y));
    }

    private int[] merge(int[] array1, int[] array2) {
        int[] sortArray = new int[array1.length + array2.length];
        int i = 0, j = 0, index = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                sortArray[index++] = array1[i];
                i++;
            } else {
                sortArray[index++] = array2[j];
                j++;
            }
        }
        while (i < array1.length) {
            sortArray[index++] = array1[i++];
        }
        while (j < array2.length) {
            sortArray[index++] = array2[j++];
        }
        return sortArray;
    }
}
