package org.gd.leetcode.p0347;

import java.util.*;

/**
 * @author Horkhover Dmytro
 * @see SortSolution
 * @since 2020-08-10
 */
class LinkedListSolution implements Solution {

    private CountNode head, tail;

    public int[] topKFrequent(final int[] nums, final int k) {

        if (nums == null || nums.length == 0)
            return nums;

        head = tail = new CountNode(-1);
        CountNode.connect(head, tail);
        head.insertRight(new CountNode(0));

        Map<Integer, Node> nodeMap = new HashMap<>(nums.length);

        for (int num : nums) {

            Node node = nodeMap.get(num);
            if (node == null) {

                node = new Node(num);
                head.next(0).add(node);
                nodeMap.putIfAbsent(num, node);

            } else {

                CountNode parent = node.parent;
                node.unlink();
                parent.next().add(node);
                if (parent.isEmpty())
                    parent.unlink();
            }
        }

        int i = 0;
        int[] result = new int[Math.min(k, nodeMap.size())];
        Iterator<Node> iterator = new DownIterator(tail);
        while (iterator.hasNext() && i < result.length)
            result[i++] = iterator.next().value;

        return result;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        CountNode next = head.next;
        while (next != tail) {
            sj.add(next.toString());
            next = next.next;
        }
        return sj.toString();
    }

    static class CountNode {
        final int count;
        CountNode prev, next;
        Node head, tail;

        CountNode(int count) {
            this.count = count;
            head = tail = new Node(-1, this);
            Node.connect(head, tail);
        }

        static void connect(CountNode prev, CountNode next) {
            if (prev != null)
                prev.next = next;
            if (next != null)
                next.prev = prev;
        }

        boolean isEmpty() {
            return head.next == tail;
        }

        CountNode next() {
            return next(count + 1);
        }

        CountNode next(int count) {
            if (next.count == count)
                return next;

            CountNode next = new CountNode(count);
            insertRight(next);
            return next;
        }

        void insertRight(CountNode node) {
            connect(node, next);
            connect(this, node);
        }

        void add(Node node) {
            node.parent = this;
            head.insertRight(node);
        }

        void unlink() {
            connect(prev, next);
            prev = null;
            next = null;
        }

        @Override
        public String toString() {
            StringJoiner sj = new StringJoiner(", ", count + " -> [", "]");
            Node next = head.next;
            while (next != tail) {
                sj.add("" + next.value);
                next = next.next;
            }
            return sj.toString();
        }
    }

    static class Node {

        final int value;
        CountNode parent;
        Node prev, next;

        Node(int value) {
            this.value = value;
        }

        Node(int value, CountNode parent) {
            this.value = value;
            this.parent = parent;
        }

        static void connect(Node prev, Node next) {
            if (prev != null)
                prev.next = next;
            if (next != null)
                next.prev = prev;
        }

        void insertRight(Node node) {
            node.parent = parent;
            Node next = this.next;
            connect(this, node);
            connect(node, next);
        }

        void unlink() {
            connect(prev, next);
            prev = null;
            next = null;
            parent = null;
        }
    }

    static class DownIterator implements Iterator<Node> {

        CountNode countNode;
        Node node = null;

        DownIterator(CountNode countNode) {
            this.countNode = countNode;
        }

        @Override
        public boolean hasNext() {
            if (countNode == null)
                return false;

            if (node == null)
                node = countNode.tail.prev;

            if (node != countNode.head)
                return true;

            node = null;
            countNode = countNode.prev;
            return hasNext();
        }

        @Override
        public Node next() {
            if (!hasNext())
                throw new NoSuchElementException();

            Node value = this.node;
            this.node = this.node.prev;
            return value;
        }
    }
}
