package org.gd.leetcode.p0662;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.util.ArrayList;

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

    private int maxWidth;
    private ArrayList<ArrayList<TreeNode>> lines;

    private void reset() {
        maxWidth = 0;
        lines = new ArrayList<>();
    }

    private static int count(ArrayList<TreeNode> line) {
        int size = line.size();
        int i = 0;
        int j = size - 1;
        while (i < size && line.get(i) == null)
            i++;
        while (j > 0 && line.get(j) == null)
            j--;
        return j - i + 1;
    }

    private void add(TreeNode node, int level) {
        if (lines.size() == level) {
            lines.add(new ArrayList<>());
        }
        ArrayList<TreeNode> line = lines.get(level);
        line.add(node);
        maxWidth = Math.max(maxWidth, count(line));
    }

    private void traverse(TreeNode node, final int level) {
        add(node, level);
        if (node != null && (node.left != null || node.right != null)) {
            traverse(node.left, level + 1);
            traverse(node.right, level + 1);
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        reset();
        traverse(root, 0);
        return maxWidth;
    }

    static class Line {

        private int count = 0;

        void add(TreeNode node) {
            if (count == 0) {
                if (node != null) {
                    count++;
                }
            } else {
                count++;
            }
        }
    }
}
