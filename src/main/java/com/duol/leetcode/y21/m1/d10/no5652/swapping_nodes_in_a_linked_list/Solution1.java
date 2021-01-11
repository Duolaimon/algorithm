/**
 * Leetcode - swapping_nodes_in_a_linked_list
 */
package com.duol.leetcode.y21.m1.d10.no5652.swapping_nodes_in_a_linked_list;
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

    public ListNode swapNodes(ListNode head, int k){
        ListNode n1 = head;
        int length = 0;
        while (n1 != null) {
            length++;
            n1 = n1.next;
        }
        int index1 = k - 1;
        int index2 = length - k;
        ListNode node1 = head, node2 = head;
        for (int i = 0; i < index1 && node1 != null; i++) {
            node1 = node1.next;
        }
        for (int i = 0; i < index2 && node2 != null; i++) {
            node2 = node2.next;
        }
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
        return head;
    }

}
