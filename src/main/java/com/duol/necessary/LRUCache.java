package com.duol.necessary;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HeJiaGeng
 * @date 2021/3/31
 * @desc
 */
public class LRUCache {
    private Map<Integer, DLinkedNode> cache;
    private DLinkedNode head, tail;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkedNode(0, 0);
        tail = new DLinkedNode(0, 0);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        move2head(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            move2head(node);
        } else {
            node = new DLinkedNode(key, value);
            add2head(node);
            cache.put(key, node);
            size++;
            if (size > capacity) {
                cache.remove(tail.pre.key);
                removeNode(tail.pre);
                size--;
            }
        }
    }

    private void add2head(DLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void move2head(DLinkedNode node) {
        removeNode(node);
        add2head(node);
    }

    private class DLinkedNode {
        private int key, value;
        private DLinkedNode pre, next;

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
