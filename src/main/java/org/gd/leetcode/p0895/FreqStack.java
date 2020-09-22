package org.gd.leetcode.p0895;

import org.gd.leetcode.common.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * https://leetcode.com/problems/maximum-frequency-stack/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0146.LRUCache
 * @see org.gd.leetcode.p0460.LFUCache
 * @since 2020-09-22
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Maximum Frequency Stack",
        difficulty = LeetCode.Level.HARD,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.STACK,
                LeetCode.Tags.HASH_TABLE
        }
)
class FreqStack {

    private final Node1 head1;
    private final Node1 tail1;

    private final Map<Integer, Node2> map;

    public FreqStack() {
        head1 = new Node1(0);
        tail1 = new Node1(0);
        connect(head1, tail1);

        map = new HashMap<>();
    }

    public void push(int x) {

        Node2 node2 = map.get(x);

        if (node2 == null) {
            Node1 node1 = head1.next();
            node2 = new Node2(x, node1);
            node1.insert(node2);
            map.put(x, node2);
            return;
        }

        node2 = node2.copy();
        map.put(node2.value, node2);
    }

    public int pop() {

        Node1 prev = tail1.prev;
        if (head1 == prev)
            throw new NoSuchElementException();

        Node2 node2 = prev.head2.next;
        Node1 parent = node2.parent;
        node2.unlink();
        map.put(node2.value, node2.chainedPrev);

        if (parent.isEmpty())
            parent.unlink();

        return node2.value;

    }

    private static void connect(Node1 prev, Node1 next) {
        if (prev != null)
            prev.next = next;
        if (next != null)
            next.prev = prev;
    }

    private static void connect(Node2 prev, Node2 next) {
        if (prev != null)
            prev.next = next;
        if (next != null)
            next.prev = prev;
    }

    static class Node1 {

        private Node1 prev, next;
        private final Node2 head2;
        private final int count;

        Node1(int count) {
            this.count = count;
            head2 = new Node2(0, this);
        }

        Node1 next() {

            // ----- no next node ----
            if (next == null) {
                next = new Node1(count + 1);
                connect(this, next);
                return next;
            }

            // ----- next node has next count ( count + 1 ) ----
            if ((next.count - 1) == count) {
                return next;
            }

            // ----- next node is missed ----
            Node1 next = this.next;
            Node1 newNext = new Node1(count + 1);
            connect(this, newNext);
            connect(newNext, next);

            return newNext;
        }

        boolean isEmpty() {
            return head2.next == null;
        }

        void unlink() {
            if (count == 0)
                return;

            connect(prev, next);
            prev = null;
            next = null;
        }

        void insert(Node2 node2) {
            Node2 next2 = head2.next;
            node2.parent = this;
            connect(head2, node2);
            connect(node2, next2);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder()
                    .append("[").append(count).append("] -> ");

            Node2 node2 = this.head2.next;
            boolean firstElement = true;
            while (node2 != null) {
                if (!firstElement)
                    sb.append(", ");
                sb.append(node2.value);
                firstElement = false;
                node2 = node2.next;
            }
            return sb.toString();
        }
    }

    static class Node2 {

        final int value;
        Node1 parent;
        Node2 chainedPrev, next, prev;

        Node2(int value, Node1 parent) {
            this.value = value;
            this.parent = parent;
        }

        void unlink() {
            connect(prev, next);
            prev = null;
            next = null;
            parent = null;
        }

        Node2 copy() {
            Node1 nextParent = parent.next();
            Node2 newNode = new Node2(value, null);
            nextParent.insert(newNode);
            newNode.chainedPrev = this;
            return newNode;
        }

        @Override
        public String toString() {
            if (parent == null)
                return "" + value;
            return String.format("%d [%d]", value, parent.count);
        }
    }
}
