package org.gd.leetcode.p0430;

import java.util.Objects;

class Node {
    public int val;
    public Node prev, next, child;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return val == node.val && Objects.equals(next, node.next) && Objects.equals(child, node.child);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next, child);
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
