package org.gd.leetcode.p0783;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0530.Solution
 * @since 2020-09-11
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Minimum Distance Between BST Nodes",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.RECURSION
        }
)
class Solution {

    private int min = Integer.MAX_VALUE;
    private TreeNode prev;

    private static int diff(TreeNode v1, TreeNode v2) {
        return Math.abs(v1.val - v2.val);
    }

    public int minDiffInBST(TreeNode root) {
        if (root == null)
            return 0;

        minDiffInBST(root.left);
        if (prev != null) {
            min = Math.min(min, diff(prev, root));
        }
        prev = root;
        minDiffInBST(root.right);

        return min;
    }
}
