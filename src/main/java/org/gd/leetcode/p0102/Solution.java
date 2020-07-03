package org.gd.leetcode.p0102;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * @author Horkhover Dmytro
 * @since 2018-12-20
 */
@LeetCode(
        name = "Binary Tree Level Order Traversal",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.BREADTH_FIRST_SEARCH
        }
)
class Solution {

    private List<List<Integer>> result;

    private static int deep(TreeNode node) {
        return node == null ? 0 : 1 + Math.max(deep(node.left), deep(node.right));
    }

    private List<List<Integer>> fill(TreeNode node, int level) {
        if (node != null) {
            result.get(level).add(node.val);
            fill(node.left, level + 1);
            fill(node.right, level + 1);
        }
        return result;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        final int deep = deep(root);

        result = new ArrayList<>(deep);
        for (int i = 0; i < deep; i++)
            result.add(new ArrayList<>());

        return fill(root, 0);
    }
}
