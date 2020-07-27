package org.gd.leetcode.p0155;

/**
 * @since 2019-09-10
 */
class LinkedMinStack implements MinStack {

    private Node head = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE, null);

    @Override
    public void push(int x) {
        head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() { head = head.next; }

    public int top() { return head.val; }

    public int getMin() { return head.min; }

    static class Node {

        int val;
        int min;
        Node next;

        Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
