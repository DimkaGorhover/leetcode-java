package org.gd.leetcode.p0662;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

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

    private int level;
    private ArrayList<TreeNode> levelNodes;

    private void reset() {
        level = 0;
        levelNodes = new ArrayList<>();
    }

    private void traverse(TreeNode node, final int level) {
        if (this.level == level) {
            levelNodes.add(node);
        } else if (this.level < level) {
            this.level = level;
            levelNodes = new ArrayList<>();
            levelNodes.add(node);
        }
        if (node != null && (node.left != null || node.right != null)) {
            traverse(node.left, level + 1);
            traverse(node.right, level + 1);
        }
    }

    private int count() {
        int size = levelNodes.size();
        int i = 0;
        int j = size - 1;
        while (i < size && levelNodes.get(i) == null)
            i++;
        while (j > 0 && levelNodes.get(j) == null)
            j--;
        return j - i + 1;
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        reset();
        traverse(root, 0);
        return count();
    }
}
