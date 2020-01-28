/**
 * Leetcode - add_two_numbers
 */
package com.duol.leetcode.add_two_numbers;

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode(0);
        ListNode l = result;
        int carry = 0;
        int val1, val2;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                val1 = 0;
            } else {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 == null) {
                val2 = 0;
            } else {
                val2 = l2.val;
                l2 = l2.next;
            }
            int sum = carry + val1 + val2;
            carry = sum / 10;
            l.next = new ListNode(sum % 10);
            l = l.next;
        }
        if (carry > 0) {
            l.next = new ListNode(carry);
        }
        return result.next;
    }

}
