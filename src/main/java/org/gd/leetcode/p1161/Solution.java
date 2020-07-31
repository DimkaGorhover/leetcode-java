package org.gd.leetcode.p1161;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 *
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 *
 * Return the smallest level X such that the sum of all the values of nodes at level X is maximal.
 *
 * @since 2019-09-23
 */
@LeetCode(
        name = "Maximum Level Sum of a Binary Tree",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.GRAPH
        })
class Solution {

    private int[] sums;

    private static int deep(TreeNode node) {
        return node == null ? 0 : 1 + Math.max(deep(node.left), deep(node.right));
    }

    private void traverse(TreeNode node, int level) {
        if (node == null)
            return;

        sums[level] += node.val;

        traverse(node.left, level + 1);
        traverse(node.right, level + 1);
    }

    public int maxLevelSum(TreeNode root) {

        if (root == null)
            return 0;

        sums = new int[deep(root)];

        traverse(root, 0);

        int level = 0;
        for (int i = 1; i < sums.length; i++)
            if (sums[level] < sums[i])
                level = i;

        return level + 1;
    }
}
