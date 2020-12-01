/**
 * Leetcode - four_divisors
 */
package com.duol.leetcode.y20.before.four_divisors;

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

    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            int numSum = 0;
            int size = 0;
            for (int i = 1; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    if (num / i == i) {
                        size++;
                        numSum += i;
                    } else {
                        size += 2;
                        numSum += i + num / i;
                    }
                }
                if (size > 4) {
                    break;
                }
            }
            if (size == 4) {
                sum += numSum;
            }
        }
        return sum;
    }

}
