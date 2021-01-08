/**
 * Leetcode - rotate_array
 */
package com.duol.leetcode.y21.m1.d8.no189.rotate_array;
import java.util.*;
import com.duol.common.*;

/** 
 * 辅助数组
 * 空间O(n)
 */
class Solution1 implements Solution {

    public void rotate(int[] nums, int k){
        int length = nums.length;
        int[] newNums = new int[length];
        for (int i = 0; i < nums.length; i++) {
            int index = (i + k) % length;
            newNums[index] = nums[i];
        }
        for (int i = 0; i < length; i++) {
            nums[i] = newNums[i];
        }
    }

}
