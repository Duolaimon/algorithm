/**
 * Leetcode - linked_list_middle_node
 */
package com.duol.leetcode.y20.before.linked_list_middle_node;

import com.duol.common.*;

/**
 * 快慢指针，1速和2速
 */
class Solution2 implements Solution {

    public ListNode middleNode(ListNode head) {
        ListNode one = head;
        ListNode two = head;
        while (two.next != null) {
            one = one.next;
            two = two.next;
            if (two.next == null) {
                return one;
            } else {
                two = two.next;
            }
        }
        return one;
    }

}
