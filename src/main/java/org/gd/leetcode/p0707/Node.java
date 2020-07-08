package org.gd.leetcode.p0707;

class Node {

    final int value;
    Node left, right;

    Node(int value) { this.value = value; }

    private static void connect(Node left, Node right) {
        if (left != null) left.right = right;
        if (right != null) right.left = left;
    }

    void unlink() {
        if (left != null) left.right = right;
        if (right != null) right.left = left;
    }

    Node insertBefore(Node right) {
        if (right != null) {
            Node left = right.left;
            connect(this, right);
            connect(left, this);
        }
        return this;
    }

    Node insertAfter(Node left) {
        if (left != null) {
            Node right = left.right;
            connect(left, this);
            connect(this, right);
        }
        return this;
    }

    @Override
    public int hashCode() { return value; }

    @Override
    public String toString() { return "" + value; }
}
