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

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this(val, null, null);
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static Builder builder() {
        return new TreeNodeBuilder();
    }

    public static TreeNode of(Integer value) {
        return value == null ? null : of(value.intValue());
    }

    public static TreeNode of(int value) {
        return new TreeNode(value);
    }

    public static TreeNode of(Integer... values) {
        requireNonNull(values, "values");
        if (values.length < 1)
            throw new IllegalArgumentException("values should contain at least one element");
        final TreeNode head = new TreeNode(requireNonNull(values[0], "first value cannot be NULL"));
        List<TreeNode> nodes = List.of(head);
        int i = 1;
        TreeNode tmp;
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

    @Deprecated
    public long sum() {
        return sum(this);
    }

    private static long sum(TreeNode node) {
        return node == null ? 0 : node.val + sum(node.left) + sum(node.right);
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
        result = 31 * result + Objects.hashCode(left);
        result = 31 * result + Objects.hashCode(right);
        return result;
    }

    public String toTreeString() {
        StringBuilder sb = new StringBuilder();
        toTreeString(sb, this, 0);
        sb.append('\n');
        return sb.toString();
    }

    @SuppressWarnings("StringRepeatCanBeUsed")
    private static void toTreeString(StringBuilder sb, TreeNode node, int level) {
        if (node == null)
            return;

        if (level > 0) {
            sb.append('\n');
            for (int i = 0; i < level; i++)
                sb.append(' ');
            sb.append('├').append('─');
        }
        sb.append('(').append(' ').append(node.val).append(' ').append(')');
        toTreeString(sb, node.left, level + 2);
        toTreeString(sb, node.right, level + 2);
    }

    @Override
    public String toString() {
        return "" + val + (left == null && right == null ? "" : ("(" + left + "^" + right + ")"));
    }

    public interface Builder {

        Builder val(int val);

        Builder left(TreeNode node);

        default Builder left(Builder node) { return left(node.build()); }

        default Builder left(int val) { return left(TreeNode.of(val)); }

        Builder right(TreeNode node);

        default Builder right(Builder node) { return right(node.build()); }

        default Builder right(int val) { return right(TreeNode.of(val)); }

        TreeNode build();
    }
}
