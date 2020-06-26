package org.gd.leetcode.p0687;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/longest-univalue-path/
 */
@LeetCode(difficulty = LeetCode.Level.EASY)
class Solution {

    public int longestUnivaluePath(TreeNode root) {

        if (root == null)
            return 0;

        return Math.max(0, Math.max(
            longestUnivaluePath(root.left, 0, root.val), 
            longestUnivaluePath(root.right, 0, root.val)
        ));
    }

    private static int longestUnivaluePath(TreeNode node, int deep, int value) {

        if (node == null)
            return deep;

        return Math.max(
            
            node.val != value ? deep : Math.max(
                longestUnivaluePath(node.left, deep + 1, value), 
                longestUnivaluePath(node.right, deep + 1, value)), 

            Math.max(
                longestUnivaluePath(node.left, 0, node.val), 
                longestUnivaluePath(node.right, 0, node.val)
            )
        );
    }
}
