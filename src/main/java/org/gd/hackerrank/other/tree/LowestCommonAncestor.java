package org.gd.hackerrank.other.tree;

import org.gd.hackerrank.common.HackerRank;

/**
 * https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/
 *
 * @author Horkhover D.
 * @see org.gd.leetcode.p0235.Solution
 * @since 2020-07-15
 */
@SuppressWarnings({"JavadocReference", "unused"})
@HackerRank(difficulty = HackerRank.Level.EASY)
class LowestCommonAncestor {

    private LowestCommonAncestor() { throw new UnsupportedOperationException(); }

    public static Node lca(Node root, int left, int right) {
        if (left > right)
            return lca(root, right, left);

        while (root != null && (root.data > right || root.data < left))
            root = root.data > right ? root.left : root.right;

        return root;
    }
}
