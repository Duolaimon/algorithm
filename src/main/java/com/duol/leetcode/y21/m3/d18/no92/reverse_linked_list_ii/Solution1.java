/**
 * Leetcode - reverse_linked_list_ii
 */
package com.duol.leetcode.y21.m3.d18.no92.reverse_linked_list_ii;

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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int index = 1;
        Stack<Integer> stack = new Stack<>();
        ListNode res = new ListNode(0);
        ListNode t = res;
        while (head != null) {
            if (index >= left && index <= right) {
                stack.push(head.val);
            } else {
                while (!stack.isEmpty()) {
                    Integer pop = stack.pop();
                    t.next = new ListNode(pop);
                    t = t.next;
                }
                t.next = new ListNode(head.val);
                t = t.next;
            }
            index++;
            head = head.next;
        }
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            t.next = new ListNode(pop);
            t = t.next;
        }
        return res.next;
    }

}
