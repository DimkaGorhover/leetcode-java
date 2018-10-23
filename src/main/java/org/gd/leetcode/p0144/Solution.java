package org.gd.leetcode.p0144;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Gorkhover D.
 * @since 2018-10-23
 */
class Solution {

    private static List<Integer> preorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
        return list;
    }

    private static List<Integer> recursive0(TreeNode root) {
        return preorderTraversal(root, new ArrayList<>());
    }

    private static List<Integer> loop0(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        List<Integer>  integers = new ArrayList<>();
        List<TreeNode> nodes    = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            List<TreeNode> newNodes = new ArrayList<>(4);
            for (TreeNode node : nodes) {
                integers.add(node.val);
                if (node.left != null) newNodes.add(node.left);
                if (node.right != null) newNodes.add(node.right);
            }
            nodes = newNodes;
        }
        return integers;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        return recursive0(root);
    }
}
