/**
 * Leetcode - reverse_linked_list_ii
 */
package com.duol.leetcode.y21.m3.d18.no92.reverse_linked_list_ii;
import java.util.*;
import com.duol.common.*;

/** 
 * 每遍历一个需要翻转的节点，将该节点插到翻转区域头结点
 * 1,2,3,4,5
 *
 *     |
 *     V
 *
 * 1,3,2,4,5
 *
 *     |
 *     V
 *
 * 1,4,3,2,5
 */
class Solution2 implements Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }

}
