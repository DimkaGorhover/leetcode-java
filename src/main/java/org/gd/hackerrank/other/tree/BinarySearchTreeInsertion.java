package org.gd.hackerrank.other.tree;

import org.gd.hackerrank.common.HackerRank;

/**
 * @author Horkhover D.
 * @since 2020-07-17.07.2020
 */
@HackerRank(difficulty = HackerRank.Level.EASY)
class BinarySearchTreeInsertion {

    private BinarySearchTreeInsertion() { throw new UnsupportedOperationException(); }

    public static Node insert(Node root,int data) {
        if (root == null || root.data == data)
            return root;

        if (data < root.data)
            insert(root.left, data);
        else
            insert(root.right, data);

        return root;
    }
}
