/**
 * Leetcode - partition_list
 */
package com.duol.leetcode.y21.m1.d3.no86.partition_list;

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

    public ListNode partition(ListNode head, int x) {
        ListNode result = new ListNode(-1);
        ListNode node = result;
        List<Integer> ge = new ArrayList<>();
        while (head != null) {
            if (head.val < x) {
                node.next = new ListNode(head.val);
                node = node.next;
            } else {
                ge.add(head.val);
            }
            head = head.next;
        }
        for (Integer integer : ge) {
            node.next = new ListNode(integer);
            node = node.next;
        }
        return result.next;
    }

}
