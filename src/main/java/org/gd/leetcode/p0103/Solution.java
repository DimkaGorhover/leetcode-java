package org.gd.leetcode.p0103;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * @author Horkhover Dmytro
 * @since 2020-07-25
 */
@LeetCode(
        name = "Binary Tree Zigzag Level Order Traversal",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
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

    private void traverse(final TreeNode node, final int level) {
        if (node == null)
            return;

        List<Integer> line = result.get(level);
        if (level % 2 == 0) {
            line.add(node.val);
        } else {
            ((LinkedList<Integer>) line).addFirst(node.val);
        }

        traverse(node.left, level + 1);
        traverse(node.right, level + 1);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null)
            return Collections.emptyList();

        int capacity = height(root);
        result = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++)
            result.add(i % 2 == 0 ? new ArrayList<>(Math.max(i * 2, 1)) : new LinkedList<>());

        traverse(root, 0);
        return result;
    }
}
