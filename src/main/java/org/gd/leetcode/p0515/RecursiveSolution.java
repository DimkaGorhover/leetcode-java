package org.gd.leetcode.p0515;

import org.gd.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-15
 */
class RecursiveSolution implements Solution {

    private List<Integer> result = new ArrayList<>();

    private void traverse(final TreeNode node, final int level) {
        if (node == null)
            return;

        if (result.size() == level) {
            result.add(node.val);
        } else {
            result.set(level, Math.max(result.get(level), node.val));
        }

        traverse(node.left, level + 1);
        traverse(node.right, level + 1);
    }

    public List<Integer> largestValues(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        result = new ArrayList<>();
        traverse(root, 0);
        return result;
    }
}
