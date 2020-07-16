package org.gd.hackerrank.other.tree;

import org.gd.hackerrank.common.HackerRank;

/**
 * https://www.hackerrank.com/challenges/tree-preorder-traversal/
 *
 * @author Horkhover D.
 * @since 2020-07-15
 */
@SuppressWarnings("unused")
@HackerRank(difficulty = HackerRank.Level.EASY)
class TreePreorderTraversal {

    private TreePreorderTraversal() { throw new UnsupportedOperationException(); }

    public static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
}
