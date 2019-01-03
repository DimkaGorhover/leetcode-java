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
@LeetCode(difficulty = LeetCode.Level.MEDIUM)
class Solution {

    private static int deep(TreeNode node) {
        return node == null ? 0 : 1 + Math.max(deep(node.left), deep(node.right));
    }

    private static List<List<Integer>> fill(List<List<Integer>> list, TreeNode node, int level) {
        if (node != null) {
            list.get(level).add(node.val);
            fill(list, node.left, level + 1);
            fill(list, node.right, level + 1);
        }
        return list;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        final int           deep   = deep(root);
        List<List<Integer>> levels = new ArrayList<>(deep);
        for (int i = 0; i < deep; i++)
            levels.add(new ArrayList<>());
        return fill(levels, root, 0);
    }
}
