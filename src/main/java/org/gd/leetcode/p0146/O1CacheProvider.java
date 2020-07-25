package org.gd.leetcode.p0146;

import java.util.HashMap;
import java.util.Map;

/**
 * @see org.gd.leetcode.p0460.O1CacheProvider
 */
@SuppressWarnings({"DuplicatedCode", "JavadocReference"})
class O1CacheProvider implements CacheProvider {

    private final Node head;
    private final Node tail;
    private final Map<Integer, Node> map;
    private final int capacity;

    O1CacheProvider(int capacity) {
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.right = tail;
        tail.left = head;

        map = new HashMap<>(this.capacity = capacity);
    }

    @Override
    public int get(int key) {
        Node node = map.get(key);
        if (node == null)
            return -1;

        node.unlink();
        head.insertRight(node);
        return node.value;
    }

    @Override
    public void put(int key, int value) {

        Node node = map.get(key);
        if (node != null) {

            node.value = value;
            node.unlink();
            head.insertRight(node);

            return;
        }

        if (map.size() == capacity) {

            node = tail.left;
            node.unlink();
            map.remove(node.key);

        }

        head.insertRight(node = new Node(key, value));
        map.put(node.key, node);
    }


    static class Node {

        final int key;
        int value;
        Node left, right;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        void unlink() {
            left.right = right;
            right.left = left;
        }

        void insertThisBetween(Node left, Node right) {
            this.left = left;
            this.right = right;
            left.right = this;
            right.left = this;
        }

        void insertRight(Node node) {
            node.insertThisBetween(this, right);
        }
    }
}
