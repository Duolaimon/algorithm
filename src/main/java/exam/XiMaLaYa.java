package exam;

import com.duol.common.ListNode;

import java.util.List;

/**
 * @author HeJiaGeng
 * @date 2021/4/6
 * @desc
 */
public class XiMaLaYa {
    private static XiMaLaYa instance;
    public static XiMaLaYa getInstance2() {
        if (instance == null) {
            synchronized (XiMaLaYa.class) {
                if (instance == null) {
                    instance = new XiMaLaYa();
                }
            }
        }
        return instance;
    }

    public static XiMaLaYa getInstance() {
        return XiMaLaYaHandler.instance;
    }

    private static class XiMaLaYaHandler{
        private static XiMaLaYa instance = new XiMaLaYa();

    }












    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur;

        while (head.next != null) {
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        head.next = pre;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 2; i < 10; i++) {
            head.next = new ListNode(i);
            head = head.next;
        }
        ListNode reverse = reverse(node);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }
}
