package org.gd.leetcode.p0404;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-24
 */
@LeetCode(
        name = "Sum of Left Leaves",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.TREE
)
class Solution {

    private static boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    private static int traverse(TreeNode node, boolean left) {
        if (node == null)
            return 0;

        if (isLeaf(node) && left)
            return node.val;

        int leftSum = traverse(node.left, true);
        int rightSum = traverse(node.right, false);
        return leftSum + rightSum;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return traverse(root, false);
    }
}
