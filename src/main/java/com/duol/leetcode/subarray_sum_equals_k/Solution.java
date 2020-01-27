/**
 * Leetcode - subarray_sum_equals_k
 */
package com.duol.leetcode.subarray_sum_equals_k;

import java.util.*;

import com.duol.common.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * No.560
 * <p>
 * Given an array of integers and an integer k,
 * you need to find the total number of continuous subarrays whose sum equals to k.
 * <p>
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
interface Solution {

    // use this Object to print the log (call from slf4j facade)
    Logger log = LoggerFactory.getLogger(Solution.class);

    int subarraySum(int[] nums, int k);
}
