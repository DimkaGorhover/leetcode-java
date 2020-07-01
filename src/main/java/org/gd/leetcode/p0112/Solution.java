package org.gd.leetcode.p0112;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/path-sum/
 *
 * @see org.gd.leetcode.p0113.Solution
 * @see org.gd.leetcode.p0257.Solution
 */
@LeetCode(
        difficulty = LeetCode.Level.EASY,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.DEPTH_FIRST_SEARCH
        }
)
class Solution {

    private static boolean traverse(TreeNode root, int sum, int target) {
        sum += root.val;
        if (root.left == null && root.right == null)
            return sum == target;

        return (root.left != null && traverse(root.left, sum, target))
                || (root.right != null && traverse(root.right, sum, target));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return root != null && traverse(root, 0, sum);
    }
}
