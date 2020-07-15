package org.gd.hackerrank.other.tree;

import org.gd.hackerrank.common.HackerRank;

/**
 * https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/
 *
 * @author Horkhover D.
 * @since 2020-07-15
 */
@HackerRank(difficulty = HackerRank.Level.EASY)
class HeightBinaryTree {

    private static int height0(Node root) {
        return root == null ? 0 : 1 + Math.max(height0(root.left), height0(root.right));
    }

    public static int height(Node root) {
        return root == null ? 0 : height0(root) - 1;
    }
}
