package org.gd.leetcode.p0513;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

@LeetCode(
        name = "Find Bottom Left Tree Value",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.DEPTH_FIRST_SEARCH,
                LeetCode.Tags.BREADTH_FIRST_SEARCH
        }
)
class Solution {

    private int maxLevel;
    private int value;

    private void traverse(final TreeNode root, final int level) {
        if (root == null)
            return;

        if (level > maxLevel) {
            maxLevel = level;
            value = root.val;
        }

        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }

    public int findBottomLeftValue(TreeNode root) {
        if (root == null)
            throw new NullPointerException();

        value = root.val;
        maxLevel = 0;

        traverse(root, 0);

        return value;
    }
}
