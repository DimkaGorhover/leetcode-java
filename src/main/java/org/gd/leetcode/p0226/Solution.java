package org.gd.leetcode.p0226;

/**
 * @author Gorkhover D.
 * @since 2018-10-22
 */
class Solution {

    private static void invertTree0(TreeNode root) {
        if (root == null)
            return;
        final TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree0(root.left);
        invertTree0(root.right);
    }

    public TreeNode invertTree(TreeNode root) {
        invertTree0(root);
        return root;
    }
}
