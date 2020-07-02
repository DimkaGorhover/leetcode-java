package org.gd.leetcode.p0430;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(doNotUseGetters = true)
class Node {
    public int val;

    @EqualsAndHashCode.Exclude
    public Node prev;

    public Node next;

    public Node child;

    Node() {
    }

    Node(int val) {
        this.val = val;
    }

    static Node of(int... values) {
        Node head = new Node(values[0]), prev = head;
        for (int i = 1; i < values.length; i++)
            prev = Solution.connect(prev, new Node(values[i]));
        return head;
    }

    @Override
    public String toString() {
        return "" + val +
                (prev == null ? "" : " (parent=" + prev.val + ")") +
                (child == null ? "" : " child" + child) +
                (next == null ? "" : " ->" + next + "") +
                "";
    }
}
