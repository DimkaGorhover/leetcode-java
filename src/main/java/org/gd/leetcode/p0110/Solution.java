package org.gd.leetcode.p0110;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * FIXME: https://leetcode.com/problems/balanced-binary-tree/
 *
 * @author Horkhover Dmytro
 * @since 2018-11-18
 */
@LeetCode(
        difficulty = LeetCode.Level.EASY,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.DEPTH_FIRST_SEARCH
        }
)
class Solution {

    private int length(TreeNode node) {
        return node == null ? 0 : 1 + Math.max(length(node.left), length(node.right));
    }

    public boolean isBalanced(TreeNode root) {
        return root == null || (Math.abs(length(root.left) - length(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right));
    }
}
