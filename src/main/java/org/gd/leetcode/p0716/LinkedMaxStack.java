package org.gd.leetcode.p0716;

/**
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0155.LinkedMinStack
 * @since 2020-08-07
 */
@SuppressWarnings("JavadocReference")
class LinkedMaxStack implements MaxStack {

    private Node head = new Node(Integer.MIN_VALUE);

    public void push(int x) {
        head = new Node(x, Math.max(x, head.val), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMax() {
        return head.max;
    }

    static class Node {

        int val;
        int max;
        Node next;

        Node(int val) {
            this(val, val, null);
        }

        Node(int val, int max, Node next) {
            this.val = val;
            this.max = max;
            this.next = next;
        }
    }
}
