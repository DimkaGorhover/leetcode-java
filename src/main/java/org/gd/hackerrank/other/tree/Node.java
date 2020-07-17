package org.gd.hackerrank.other.tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author Horkhover D.
 * @since 2020-07-15
 */
class Node {

    int data;
    Node left, right;

    Node() {}

    Node(int data) {
        this.data = data;
    }

    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    static Node of(String text) {
        String[] s = text.trim().split(" ");
        Integer[] arr = new Integer[s.length];
        for (int i = 0; i < s.length; i++) {
            Integer value = null;
            try {
                value = Integer.parseInt(s[i]);
            } catch (Throwable ignore) {}
            arr[i] = value;
        }
        return of(arr);
    }

    static Node of(Integer... values) {
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(values[0]);
        q.add(root);
        int cursor = 1;
        Node node;
        while (cursor < values.length && (node = q.poll()) != null) {
            Integer value = values[cursor];
            if (value == null) {
                node.left = null;
            } else {
                Node leftNode = new Node(value);
                node.left = leftNode;
                q.add(leftNode);
            }
            if (++cursor < values.length) {
                value = values[cursor];
                if (value == null) {
                    node.right = null;
                } else {
                    Node rightNode = new Node(value);
                    node.right = rightNode;
                    q.add(rightNode);
                }
            }
        }

        return root;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return data == node.data &&
                Objects.equals(left, node.left) &&
                Objects.equals(right, node.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, left, right);
    }
}
