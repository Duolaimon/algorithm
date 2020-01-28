/**
 * Leetcode - queue_reconstruction_by_height
 */
package com.duol.leetcode.queue_reconstruction_by_height;

import java.util.*;

import com.duol.common.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * No.406
 * <p>
 * Suppose you have a random list of people standing in a queue.
 * Each person is described by a pair of integers (h, k),
 * where h is the height of the person and k is the number of people in front of this person
 * who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 * <p>
 * Note:
 * The number of people is less than 1,100.
 * <p>
 *  
 * Example
 * <p>
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
interface Solution {

    // use this Object to print the log (call from slf4j facade)
    static Logger log = LoggerFactory.getLogger(Solution.class);

    int[][] reconstructQueue(int[][] people);
}
