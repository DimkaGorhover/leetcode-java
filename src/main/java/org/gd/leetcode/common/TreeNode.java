package org.gd.leetcode.common;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * @author Gorkhover D.
 * @since 2018-10-23
 */
@EqualsAndHashCode(doNotUseGetters = true)
public class TreeNode {

    public int      val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) { val = x; }

    public static TreeNode of(Integer value) {
        return value == null ? null : new TreeNode(value);
    }

    @SuppressWarnings("Duplicates")
    public static TreeNode of(Integer... values) {
        requireNonNull(values, "values");
        if (values.length < 1)
            throw new IllegalArgumentException("values should contain at least one element");
        final TreeNode head = new TreeNode(requireNonNull(values[0], "first value cannot be NULL"));
        List<TreeNode> nodes = List.of(head);
        int            i     = 1;
        TreeNode       tmp;
        while (!nodes.isEmpty()) {
            List<TreeNode> newNodes = new ArrayList<>(2);
            for (TreeNode node : nodes) {
                if (i < values.length && (tmp = of(values[i++])) != null) {
                    newNodes.add(tmp);
                    node.left = tmp;
                }
                if (i < values.length && (tmp = of(values[i++])) != null) {
                    newNodes.add(tmp);
                    node.right = tmp;
                }
            }
            nodes = newNodes;
        }
        return head;
    }

    @Override
    public String toString() {
        return "" + val + (left == null && right == null ? "" : ("(" + left + "^" + right + ")"));
    }
}