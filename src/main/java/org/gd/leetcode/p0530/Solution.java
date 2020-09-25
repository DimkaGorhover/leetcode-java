package org.gd.leetcode.p0530;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

//@formatter:off
/**
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 *
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * Output: 1
 *
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 *
 * Note: There are at least two nodes in this BST.
 *
 * @see org.gd.leetcode.p0783.Solution
 * @since 2019-09-14
 */
//@formatter:on
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Minimum Absolute Difference in BST",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.RECURSION
        })
class Solution {

    private int min = Integer.MAX_VALUE;
    private TreeNode prev;

    private static int diff(TreeNode v1, TreeNode v2) {
        return Math.abs(v1.val - v2.val);
    }

    public int getMinimumDifference(TreeNode root) {
        if (root == null)
            return 0;

        getMinimumDifference(root.left);
        if (prev != null) {
            min = Math.min(min, diff(prev, root));
        }
        prev = root;
        getMinimumDifference(root.right);

        return min;
    }
}
