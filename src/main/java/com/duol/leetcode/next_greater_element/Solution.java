/**
* Leetcode - next_greater_element
*/
package com.duol.leetcode.next_greater_element;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 *
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.
 * If it does not exist, output -1 for this number.
 *
 */
interface Solution {

// use this Object to print the log (call from slf4j facade)
static Logger log = LoggerFactory.getLogger(Solution.class);

    int[] nextGreaterElement(int[] para1, int[] para2);
}
