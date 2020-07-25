package org.gd.leetcode.p0103;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-25
 */
@LeetCode(
        name = "Binary Tree Zigzag Level Order Traversal",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.STACK,
                LeetCode.Tags.TREE,
                LeetCode.Tags.BREADTH_FIRST_SEARCH
        }
)
class Solution {

    private List<List<Integer>> result;

    private static int height(TreeNode node) {
        return node == null ? 0 : 1 + Math.max(height(node.left), height(node.right));
    }

    private void leftTraversal(TreeNode node, int level) {
        if (node == null)
            return;

        result.get(level).add(node.val);

        rightTraversal(node.right, level + 1);
        rightTraversal(node.left, level + 1);
    }

    private void rightTraversal(TreeNode node, int level) {
        if (node == null)
            return;

        result.get(level).add(node.val);

        leftTraversal(node.left, level + 1);
        leftTraversal(node.right, level + 1);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null)
            return Collections.emptyList();

        int capacity = height(root);
        result = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++)
            result.add(new ArrayList<>());

        leftTraversal(root, 0);
        return result;
    }
}
