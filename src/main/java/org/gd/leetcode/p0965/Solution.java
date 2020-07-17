package org.gd.leetcode.p0965;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/univalued-binary-tree/
 */
@LeetCode(
        name = "Univalued Binary Tree",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TREE
        }
)
class Solution {

    private static boolean isUnivalTree(TreeNode root, final int value) {
        return root == null || (root.val == value
                && isUnivalTree(root.left, value)
                && isUnivalTree(root.right, value));
    }

    public boolean isUnivalTree(TreeNode root) {
        return root == null || isUnivalTree(root, root.val);
    }
}
