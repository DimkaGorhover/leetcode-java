package org.gd.leetcode.p0236;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * Problem: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * Article: https://leetcode.com/articles/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author Horkhover D.
 * @see org.gd.leetcode.p0235.Solution
 * @since 2020-07-16
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Lowest Common Ancestor of a Binary Tree",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.TREE
)
class Solution {

    private static RTreeNode findNode(RTreeNode parent, TreeNode node, int value) {
        if (node == null)
            return null;

        final RTreeNode current, left, right;
        if ((current = new RTreeNode(parent, node)).val() == value)
            return current;

        if ((right = findNode(current, node.right, value)) != null && right.val() == value)
            return right;

        if ((left = findNode(current, node.left, value)) != null && left.val() == value)
            return left;

        return null;
    }

    private static TreeNode lca(TreeNode root, int p, int q) {
        RTreeNode node0 = findNode(null, root, p);
        RTreeNode node1 = findNode(null, root, q);

        while (node0.level > node1.level)
            node0 = node0.parent;

        while (node0.level < node1.level)
            node1 = node1.parent;

        while (node0.val() != node1.val()) {
            node0 = node0.parent;
            node1 = node1.parent;
        }
        return node0.val;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return root == null || p == null || q == null ? null : lca(root, p.val, q.val);
    }

    static class RTreeNode {
        final RTreeNode parent;
        final TreeNode val;
        final int level;

        RTreeNode(RTreeNode parent, TreeNode val) {
            if (val == null)
                throw new NullPointerException("val");
            this.parent = parent;
            this.val = val;
            this.level = parent == null ? 0 : parent.level + 1;
        }

        int val() { return val.val; }

        @Override
        public String toString() {
            return (parent == null ? "R_Root_Node" : "R_Tree_Node") +
                    "{val=" + val.val + ", level=" + level + '}';
        }
    }
}
