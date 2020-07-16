package org.gd.hackerrank.other.tree;

import org.gd.hackerrank.common.HackerRank;

/**
 * https://www.hackerrank.com/challenges/tree-inorder-traversal/
 *
 * @author Horkhover D.
 * @since 2020-07-15
 */
@SuppressWarnings("unused")
@HackerRank(difficulty = HackerRank.Level.EASY)
class TreeInorderTraversal {

    private TreeInorderTraversal() { throw new UnsupportedOperationException(); }

    public static void inOrder(Node root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
}
