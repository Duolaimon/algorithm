/**
 * Leetcode - monotone_increasing_digits
 */
package com.duol.leetcode.y20.m12.d15.no738.monotone_increasing_digits;

import java.util.*;

import com.duol.common.*;

/**
 *
 */
class Solution1 implements Solution {

    public int monotoneIncreasingDigits(int N) {
        int[] array = new int[9];
        int length = 0;
        while (N > 0) {
            array[length++] = N % 10;
            N /= 10;
        }
        for (int i = 0; i < length - 1; i++) {
            if (array[i] < array[i + 1]) {
                array[i] = 9;
                array[i + 1]--;
                for (int j = i - 1; j >= 0 && array[j] < array[i]; j--) {
                    array[j] = 9;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            result += array[i] * Math.pow(10, i);
        }
        return result;
    }

}
