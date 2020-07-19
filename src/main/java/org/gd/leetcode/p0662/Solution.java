package org.gd.leetcode.p0662;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 *
 * @author Horkhover Dmytro
 * @since 2020-07-18
 */
@LeetCode(
        name = "Maximum Width of Binary Tree",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.TREE
        }
)
class Solution {

    private Line[] lines;
    private int maxWidth;

    private static int height(TreeNode node) {
        return node == null ? 0 : 1 + Math.max(height(node.left), height(node.right));
    }

    private void traverse(TreeNode node, final int level, final int pos) {
        if (node == null)
            return;

        Line line = lines[level];
        if (line == null)
            lines[level] = line = new Line();

        line.add(node, pos);

        if (node.left != null || node.right != null) {
            traverse(node.left, level + 1, pos * 2);
            traverse(node.right, level + 1, pos * 2 + 1);
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        lines = new Line[height(root)];

        traverse(root, 0, 0);

        return maxWidth;

    }

    class Line {

        private int left = Integer.MAX_VALUE;
        private int right = Integer.MIN_VALUE;

        void add(TreeNode node, int pos) {
            if (node != null) {
                left = Math.min(left, pos);
                right = Math.max(right, pos);
                maxWidth = Math.max(maxWidth, length());
            }
        }

        int length() { return right - left + 1; }
    }
}
