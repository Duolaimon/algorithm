/**
 * Leetcode - rotate_list
 */
package com.duol.leetcode.y21.m3.d27.no61.rotate_list;
import java.util.*;
import com.duol.common.*;

/** 
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution1 implements Solution {

    public ListNode rotateRight(ListNode head, int k){
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        ListNode l = head;
        for (int i = 0; i < length - k - 1; i++) {
            l = l.next;
        }
        ListNode r = l.next;
        ListNode res = r;
        l.next = null;
        while (r.next != null) {
            r = r.next;
        }
        r.next = head;
        return res;
    }

}
