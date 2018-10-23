package org.gd.leetcode.p0144;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
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

    private static List<Integer> loop0(TreeNode node) {
        if (node == null)
            return Collections.emptyList();
        final List<Integer>        integers = new ArrayList<>();
        final LinkedList<TreeNode> nodes    = new LinkedList<>();
        nodes.add(node);
        while ((node = nodes.poll()) != null) {
            integers.add(node.val);
            if (node.right != null) nodes.addFirst(node.right);
            if (node.left != null) nodes.addFirst(node.left);
        }
        return integers;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        return loop0(root);
    }
}
