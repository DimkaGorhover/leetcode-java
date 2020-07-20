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
            lines[level] = line = new Line();

        line.add(pos);

        traverse(node.left, level + 1, pos * 2);
        traverse(node.right, level + 1, pos * 2 + 1);
    }

    @Override
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        lines = new Line[height(root)];
        traverse(root, 0, 1);

        System.out.println(lines[lines.length - 1]);

        return Math.toIntExact(maxWidth);

    }

    private static int length(int left, int right) {
        if (left > right)
            return length(right, left);

        return right - left + 1;
    }

    class Line {

        private int left = Integer.MAX_VALUE;
        private int right = Integer.MIN_VALUE;

        void add(int pos) {
            left = Math.min(left, pos);
            right = Math.max(right, pos);
            maxWidth = Math.max(maxWidth, length(left, right));
        }

        @Override
        public String toString() {
            return String.format("(%d : %d)", left, right);
        }
    }
}
