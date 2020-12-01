/**
* Leetcode - shortest_unsorted_continuous_subarray
*/
package com.duol.leetcode.y20.before.shortest_unsorted_continuous_subarray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * No.581
 *
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
 * then the whole array will be sorted in ascending order, too.
 *
 * You need to find the shortest such subarray and output its length.
 *
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 *
 */
interface Solution {

// use this Object to print the log (call from slf4j facade)
static Logger log = LoggerFactory.getLogger(Solution.class);

    int findUnsortedSubarray(int[] nums);
}
