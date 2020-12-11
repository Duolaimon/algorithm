/**
 * Leetcode - merge_two_sorted_lists
 */
package com.duol.leetcode.y20.m12.d10.no21.merge_two_sorted_lists;

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
class Solution2 implements Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                current.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                current.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        return result.next;
    }

}
