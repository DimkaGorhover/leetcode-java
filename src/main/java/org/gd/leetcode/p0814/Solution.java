package org.gd.leetcode.p0814;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-pruning/
 *
 * @author Horkhover Dmytro
 * @since 2018-12-18
 */
@LeetCode(difficulty = LeetCode.Level.MEDIUM, tags = LeetCode.Tags.TREE)
class Solution {

    private static void pruneLeft(TreeNode parent, TreeNode node) {
        if (node != null) {
            pruneLeft(node, node.left);
            pruneRight(node, node.right);
            if (node.left == null && node.right == null && node.val == 0)
                parent.left = null;
        }
    }

    private static void pruneRight(TreeNode parent, TreeNode node) {
        if (node != null) {
            pruneLeft(node, node.left);
            pruneRight(node, node.right);
            if (node.left == null && node.right == null && node.val == 0)
                parent.right = null;
        }
    }

    public TreeNode pruneTree(TreeNode root) {
        if (root != null) {
            pruneLeft(root, root.left);
            pruneRight(root, root.right);
        }
        return root;
    }
}
