package org.gd.leetcode.p0124;

import org.gd.common.Repeat;
import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
@Repeat("longest path in binary tree")
@LeetCode(
        difficulty = LeetCode.Level.HARD,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.DEPTH_FIRST_SEARCH
        })
class Solution {

    private int max;

    private int calcPath(TreeNode root) {
        if (root == null)
            return 0;

        int leftPath = Math.max(0, calcPath(root.left));
        int rightPAth = Math.max(0, calcPath(root.right));

        max = Math.max(max, root.val + leftPath + rightPAth);

        return Math.max(leftPath, rightPAth) + root.val;
    }

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        calcPath(root);
        return max;
    }
}
