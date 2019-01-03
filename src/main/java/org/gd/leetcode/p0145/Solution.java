package org.gd.leetcode.p0145;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 *
 * @author Gorkhover D.
 * @see org.gd.leetcode.p0144.Solution
 * @since 2018-10-23
 */
@LeetCode(difficulty = LeetCode.Level.HARD)
class Solution {

    private static List<Integer> recursive0(TreeNode node, List<Integer> integers) {
        if (node != null) {
            recursive0(node.left, integers);
            recursive0(node.right, integers);
            integers.add(node.val);
        }
        return integers;
    }

    private static List<Integer> recursive(TreeNode node) {
        return recursive0(node, new ArrayList<>());
    }

    private static List<Integer> loop(TreeNode node) {
        if (node == null)
            return Collections.emptyList();
        final List<Integer>        integers = new ArrayList<>();
        final LinkedList<TreeNode> nodes    = new LinkedList<>();

        nodes.add(node);
        while ((node = nodes.poll()) != null) {
            if (node.left != null || node.right != null) {
                nodes.addFirst(node);
                if (node.right != null) {
                    nodes.addFirst(node.right);
                    node.right = null;
                }
                if (node.left != null) {
                    nodes.addFirst(node.left);
                    node.left = null;
                }
            } else {
                integers.add(node.val);
            }
        }
        return integers;
    }


    public List<Integer> postorderTraversal(TreeNode node) {
        return loop(node);

    }
}
