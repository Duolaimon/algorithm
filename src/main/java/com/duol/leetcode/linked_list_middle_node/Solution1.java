/**
 * Leetcode - linked_list_middle_node
 */
package com.duol.leetcode.linked_list_middle_node;
import java.util.*;
import com.duol.common.*;

/** 
 * 第一遍遍历数节点个数，得到中间节点下标
 * 第二遍遍历直到中点
 */
class Solution1 implements Solution {

    public ListNode middleNode(ListNode head){
        if (head == null) {
            return null;
        }
        ListNode node = head;
        int len = 1;
        while (node.next != null) {
            len++;
            node = node.next;
        }
        int middle = len/2;
        node = head;
        while (middle != 0) {
            node = node.next;
            middle--;
        }
        return node;
    }

}
