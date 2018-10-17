package org.gd.leetcode.p0235;

/**
 * @author Gorkhover D.
 * @since 2018-10-17
 */
class TreeNode {

    int      val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                (left == null ? "" : (", left=" + left)) +
                (right == null ? "" : (", right=" + right)) +
                '}';
    }
}
