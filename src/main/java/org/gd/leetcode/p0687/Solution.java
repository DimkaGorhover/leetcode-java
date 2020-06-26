package org.gd.leetcode.p0687;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/longest-univalue-path/
 */
@LeetCode(difficulty = LeetCode.Level.EASY)
class Solution {

    int ans = 0;

    private static boolean isEqual(TreeNode parent, TreeNode child) {
        return parent != null && child != null && child.val == parent.val;
    }

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        lup(root);
        return ans;
    }

    private int lup(TreeNode node) {
        if (node == null)
            return 0;

        int leftRoot = lup(node.left);
        int rightRoot = lup(node.right);

        int left = isEqual(node, node.left) ? leftRoot + 1: 0;
        int right = isEqual(node, node.right) ? rightRoot + 1: 0;

        ans = Math.max(ans, left + right);
        return Math.max(left, right);
    }
}
