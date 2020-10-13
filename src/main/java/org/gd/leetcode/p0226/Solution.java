package org.gd.leetcode.p0226;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * @author Gorkhover D.
 * @since 2018-10-22
 */
@LeetCode(
        name = "Invert Binary Tree",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.TREE)
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
