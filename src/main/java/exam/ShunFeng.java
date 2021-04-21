package exam;

import com.duol.common.ListNode;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author HeJiaGeng
 * @date 2021/3/26
 * @desc
 */
public class ShunFeng {

    public static void main(String[] args) {
        int[] a = new int[]{0, 2, 4, 6, 8};
        int[] b = new int[]{1, 3, 5, 7, 9, 11};
        int[] res = merge(a, b);
        System.out.println(Arrays.toString(res));
    }


    public static boolean compareStr(String a, String b) {
        if (a == null) {
            return false;
        }
        if (b == null) {
            return true;
        }
        int size = Math.min(a.length(), b.length());
        for (int i = 0; i < size; i++) {
            if (a.charAt(i) > b.charAt(i)) {
                return true;
            } else if (a.charAt(i) < b.charAt(i)) {
                return false;
            }
        }
        return a.length() > b.length();
    }

    public static boolean isCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (Objects.equals(slow, fast)) {
                return true;
            }
        }
        return false;
    }


    public static int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int index = 0;
        int aIndex = 0, bIndex = 0;
        while (index < a.length + b.length) {
            if (aIndex >= a.length) {
                while (bIndex < b.length) {
                    res[index++] = b[bIndex++];
                }
            }
            if (bIndex >= b.length) {
                while (aIndex < a.length) {
                    res[index++] = a[aIndex++];
                }
            }
            if (aIndex < a.length && bIndex < b.length) {
                if (a[aIndex] < b[bIndex]) {
                    res[index++] = a[aIndex++];
                } else {
                    res[index++] = b[bIndex++];
                }
            }
        }
        return res;
    }
}
