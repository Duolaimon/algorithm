package exam;

import com.duol.common.ListNode;

/**
 * @author HeJiaGeng
 * @date 2021/4/2
 * @desc
 */
public class BaiDu {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode node = head;
        node.next = new ListNode(4);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(1);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        node.next = new ListNode(5);
        System.out.println(isHuiWen(head));
    }

    public static boolean isHuiWen(ListNode head) {
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        ListNode pre = null;
        ListNode cur;
        for (int i = 0; i < len / 2; i++) {
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        if (len % 2 == 1) {
            head = head.next;
        }
        while (head != null && pre != null) {
            if (head.val != pre.val) {
                return false;
            }
            head = head.next;
            pre = pre.next;
        }
        return true;
    }
}
