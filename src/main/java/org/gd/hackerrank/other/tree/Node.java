package org.gd.hackerrank.other.tree;

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
}
