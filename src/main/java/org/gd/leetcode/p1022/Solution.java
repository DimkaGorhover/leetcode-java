package org.gd.leetcode.p1022;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 */
@LeetCode(
        name = "Sum of Root To Leaf Binary Numbers",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.BIT_MANIPULATION
        }
)
class Solution {

    private static int sumRootToLeaf(TreeNode root, int sum) {
        sum = (sum << 1) | (root.val & 1);
        if (root.left == null && root.right == null)
            return sum;

        return (root.left == null ? 0 : sumRootToLeaf(root.left, sum))
                + (root.right == null ? 0 : sumRootToLeaf(root.right, sum));
    }

    public int sumRootToLeaf(TreeNode root) {
        return root == null ? 0 : sumRootToLeaf(root, 0);
    }
}
