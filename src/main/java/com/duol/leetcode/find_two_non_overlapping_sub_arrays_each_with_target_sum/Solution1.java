/**
 * Leetcode - find_two_non_overlapping_sub_arrays_each_with_target_sum
 */
package com.duol.leetcode.find_two_non_overlapping_sub_arrays_each_with_target_sum;

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

    public int minSumOfLengths(int[] arr, int target) {
        int result = arr.length, min = arr.length;
        boolean hasTwo = false;
        int l = 0, r = 1;
        int curSum = arr[0];
        while (r <= arr.length) {
            if (curSum == target) {
                int len = r - l;
                if (min < arr.length) {
                    hasTwo = true;
                }
                if (min + len <= result) {
                    result = min + len;
                }
                if (len <= min) {
                    min = len;
                }
                l = r;
                r++;
                if (r > arr.length) {
                    break;
                }
                curSum = arr[l];
            } else if (curSum > target) {
                l++;
                curSum -= arr[l - 1];
                if (l >= r) {
                    r++;
                    if (r > arr.length) {
                        break;
                    }
                    curSum = arr[r - 1];
                }
            } else {
                r++;
                if (r > arr.length) {
                    break;
                }
                curSum = curSum + arr[r - 1];
            }


        }
        if (!hasTwo) {
            return -1;
        }
        return result;
    }

}
