package org.gd.leetcode.p0107;

import org.gd.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 *
 * @author Horkhover Dmytro
 * @since 2018-12-12
 */
class Solution {

    private static List<List<Integer>> traverse(ArrayList<List<Integer>> lists,
                                                TreeNode node,
                                                int level) {
        if (node != null) {
            lists.get(level).add(node.val);
            traverse(lists, node.left, level - 1);
            traverse(lists, node.right, level - 1);
        }
        return lists;
    }

    private static int deep(TreeNode n) {
        return n == null ? 0 : 1 + Math.max(deep(n.left), deep(n.right));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        final int                deep  = deep(root);
        ArrayList<List<Integer>> lists = new ArrayList<>(deep);
        for (int i = 0; i < deep; i++)
            lists.add(new ArrayList<>());
        return traverse(lists, root, deep - 1);
    }
}
