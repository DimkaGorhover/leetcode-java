package org.gd.leetcode.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * @author Gorkhover D.
 * @since 2018-10-23
 */
public class TreeNode {

    public int      val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) { val = x; }

    public static TreeNode of(Integer value) {
        return value == null ? null : new TreeNode(value);
    }

    public static TreeNode of(Integer... values) {
        requireNonNull(values, "values");
        if (values.length < 1)
            throw new IllegalArgumentException("values should contain at least one element");
        final TreeNode head  = new TreeNode(requireNonNull(values[0], "first value cannot be NULL"));
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeNode)) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val &&
                Objects.equals(left, treeNode.left) &&
                Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        int result = val;
        result = 31 * result + (left != null ? left.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "" + val + (left == null && right == null ? "" : ("(" + left + "^" + right + ")"));
    }
}
