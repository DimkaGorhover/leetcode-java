package org.gd.leetcode.p0460;

import java.util.HashMap;
import java.util.Map;

/**
 * @see org.gd.leetcode.p0146.O1CacheProvider
 */
@SuppressWarnings({"JavadocReference", "DuplicatedCode", "FieldCanBeLocal"})
class O1CacheProvider implements CacheProvider {

    private final BucketNode head;
    private final BucketNode tail;

    private final Map<Integer, Node> map;
    private final int capacity;

    O1CacheProvider(int capacity) {

        head = new BucketNode(-1);
        tail = new BucketNode(-1);

        head.right = tail;
        tail.left = head;

        map = new HashMap<>(this.capacity = capacity);
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null)
            return -1;

        BucketNode parent = node.parent;
        BucketNode nextParent = parent.right;
        int count = parent.count;

        node.unlink();
        if (parent.isEmpty())
            parent.unlink();

        if (nextParent.count == count + 1) {
            nextParent.insert(node);
        } else {
            nextParent.insertLeft(new BucketNode(count + 1));
            nextParent.left.insert(node);
        }

        return node.value;
    }

    public void put(int key, int value) {

        // value already exists
        Node node = map.get(key);
        if (node != null) {

            node.value = value;

            BucketNode parent = node.parent;
            BucketNode nextParent = parent.right;
            int count = parent.count;

            node.unlink();
            if (parent.isEmpty())
                parent.unlink();

            if (nextParent.count == count) {
                nextParent.insert(node);
            } else {
                nextParent.insertLeft(new BucketNode(count + 1));
                nextParent.left.insert(node);
            }

            return;
        }

        // overcapacity
        if (map.size() == capacity) {

            node = head.right.tail.left;
            BucketNode parent = node.parent;
            node.unlink();
            if (parent.isEmpty())
                parent.unlink();
            map.remove(node.key);
        }

        if (head.right == tail || head.right.count != 0)
            head.insertRight(new BucketNode(0));

        node = new Node(key, value);
        head.right.insert(node);
        map.put(node.key, node);
    }

    @Override
    public String toString() {
        return map.toString();
    }

    static class Node {

        final int key;
        int value;
        BucketNode parent;
        Node left, right;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        void unlink() {
            left.right = right;
            right.left = left;
            parent = null;
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

    static class BucketNode {

        private final int count;
        BucketNode left, right;
        Node head, tail;

        BucketNode(int count) {

            this.count = count;

            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.parent = this;
            tail.parent = this;

            head.right = tail;
            tail.left = head;
        }

        boolean isEmpty() {
            return head.right == tail;
        }

        void insertThisBetween(BucketNode left, BucketNode right) {
            this.left = left;
            this.right = right;
            left.right = this;
            right.left = this;
        }

        void insertRight(BucketNode node) {
            node.insertThisBetween(this, right);
        }

        void insertLeft(BucketNode node) {
            node.insertThisBetween(left, this);
        }

        void insert(Node node) {
            head.insertRight(node);
            node.parent = this;
        }

        void unlink() {
            left.right = right;
            right.left = left;
            left = null;
            right = null;
        }
    }
}
