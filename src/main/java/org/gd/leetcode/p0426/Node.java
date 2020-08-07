package org.gd.leetcode.p0426;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-07
 */
class Node {

    int val;
    Node prev, next;

    Node(int val) { this.val = val; }

    static Node of(int... values) {
        Node node = new Node(values[0]);
        Node head = node;
        for (int i = 1; i < values.length; i++) {
            node = Solution.connect(node, new Node(values[i]));
        }
        return head;
    }

    static Node getHead(Node node) {
        requireNonNull(node, "\"node\" cannot be null");
        while (node.prev != null)
            node = node.prev;
        return node;
    }

    static String toString(Node node) {
        node = getHead(node);

        StringBuilder sb = new StringBuilder()
                .append('(').append(node.val).append(')');

        Node next = node.next;
        while (next != null) {
            sb.append("=>(").append(next.val).append(')');
            next = next.next;
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return val == node.val &&
                Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        int result = val;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return toString(this);
    }
}
