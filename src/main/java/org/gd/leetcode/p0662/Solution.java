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

    private TreeNode[][] lines;

    private static int height(TreeNode node) {
        return node == null ? 0 : 1 + Math.max(height(node.left), height(node.right));
    }

    private static int count(TreeNode[] line) {
        final int size = line.length;
        int i = 0;
        while (i < size && line[i] == null)
            i++;
        int j = size - 1;
        while (j >= i && line[j] == null)
            j--;
        return j - i + 1;
    }

    private void reset(TreeNode node) {
        lines = new TreeNode[height(node)][];
        int capacity = 1;
        for (int i = 0; i < lines.length; i++) {
            lines[i] = new TreeNode[capacity];
            capacity *= 2;
        }
    }

    private void traverse(TreeNode node, final int level, final int pos) {

        lines[level][pos] = node;

        if (node != null && (node.left != null || node.right != null)) {
            traverse(node.left, level + 1, pos * 2);
            traverse(node.right, level + 1, pos * 2 + 1);
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        reset(root);

        traverse(root, 0, 0);

        int max = 0;
        for (TreeNode[] line : lines)
            max = Math.max(max, count(line));

        return max;

    }
}
