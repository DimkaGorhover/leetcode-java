package org.gd.leetcode.p0226;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * @author Gorkhover D.
 * @since 2018-10-22
 */
@LeetCode(difficulty = LeetCode.Level.EASY, tags = LeetCode.Tags.TREE)
class Solution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode left = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = left;

        return root;
    }
}
