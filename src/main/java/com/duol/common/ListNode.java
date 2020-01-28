/**
 * MIT License
 * <p>
 * Copyright (c) 2018 Wei SHEN
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.duol.common;

import com.google.common.base.Objects;

/**
 * ListNode is Singly-Linked List
 * ex: 1->2->3->4->5
 *
 * @author Wei SHEN
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode newListNode(int... data) {
        ListNode first = new ListNode(data[0]);
        ListNode node = first;
        for (int i = 1; i < data.length; i++) {
            node.next = new ListNode(data[i]);
            node = node.next;
        }
        return first;
    }

    public String toString() {
        ListNode cursor = this;
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(cursor.val + "->");
            cursor = cursor.next;
        } while (cursor != null);
        int length = sb.length();
        if (length > 2) {
            sb = sb.delete(length - 2, length);
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode node = (ListNode) o;
        return val == node.val &&
                Objects.equal(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(val, next);
    }
}