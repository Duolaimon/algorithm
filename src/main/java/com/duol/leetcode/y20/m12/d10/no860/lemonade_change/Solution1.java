/**
 * Leetcode - lemonade_change
 */
package com.duol.leetcode.y20.m12.d10.no860.lemonade_change;

import java.util.*;

import com.duol.common.*;

/**
 *
 */
class Solution1 implements Solution {

    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fiveCount++;
            } else if (bill == 10) {
                if (fiveCount >= 1) {
                    fiveCount--;
                    tenCount++;
                } else {
                    return false;
                }
            } else {
                if (tenCount >= 1 && fiveCount >= 1) {
                    tenCount--;
                    fiveCount--;
                } else if (fiveCount >= 3) {
                    fiveCount -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
