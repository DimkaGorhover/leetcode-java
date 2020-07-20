package org.gd.leetcode.p0662;

import org.gd.leetcode.common.TreeNode;

/**
 * @author Horkhover Dmytro
 * @see TwoListsSolution
 * @since 2020-07-20
 */
class CustomSolution implements Solution {

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
            lines[level] = line = new Line(pos);

        maxWidth = Math.max(maxWidth, line.calcLength(pos));

        traverse(node.left, level + 1, pos * 2);
        traverse(node.right, level + 1, pos * 2 + 1);
    }

    @Override
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        lines = new Line[height(root)];
        traverse(root, 0, 1);
        return maxWidth;
    }

    static class Line {

        private final int left;

        Line(int left) { this.left = left; }

        int calcLength(int pos) { return pos - left + 1; }
    }
}
