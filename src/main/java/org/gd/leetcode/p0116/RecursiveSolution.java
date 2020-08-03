package org.gd.leetcode.p0116;

import org.gd.leetcode.common.TreeLinkNode;

/**
 * @author Horkhover Dmytro
 * @see HashTableSolution
 * @since 2020-08-03
 */
class RecursiveSolution implements Solution {

    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        if (root.left != null)
            root.left.next = root.right;

        if (root.next != null && root.right != null)
            root.right.next = root.next.left;

        connect(root.left);
        connect(root.right);
    }
}
