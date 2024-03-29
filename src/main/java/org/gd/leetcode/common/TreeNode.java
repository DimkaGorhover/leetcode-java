package org.gd.leetcode.common;

import java.util.*;

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

    public static TreeNode of() {
        return null;
    }

    public static Builder builder(int val) {
        return new TreeNodeBuilder(val);
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
        List<TreeNode> nodes = Collections.singletonList(head);
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
    public static int countNodes(TreeNode root) {
        return root == null ? 0 : 1 + countNodes(root.left) + countNodes(root.right);
    }

    @Deprecated
    public static int[] values(TreeNode root) {
        int[] result = new int[countNodes(root)];
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 0;
        while ((root = q.poll()) != null) {

            result[i++] = root.val;

            if (root.left != null)
                q.add(root.left);

            if (root.right != null)
                q.add(root.right);
        }
        return result;
    }

    /**
     * @deprecated Don't use it while solving tasks
     */
    @Deprecated
    public TreeNode copy() {
        return copy(this);
    }

    private static TreeNode copy(TreeNode head) {
        if (head == null)
            return null;
        TreeNode node = new TreeNode(head.val);
        node.left = copy(head.left);
        node.right = copy(head.right);
        return node;
    }

    @Deprecated
    public int deep() {
        return deep(this);
    }

    private static int deep(TreeNode node) {
        return node == null ? 0 : 1 + Math.max(deep(node.left), deep(node.right));
    }

    /**
     * @deprecated Don't use it while solving tasks
     */
    @Deprecated
    public long sum() {
        return sum(this);
    }

    private static long sum(TreeNode node) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(node);
        long sum = 0;
        while ((node = list.poll()) != null) {
            sum += node.val;
            if (node.left != null)
                list.offer(node.left);
            if (node.right != null)
                list.offer(node.right);
        }
        return sum;
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
        if (level > 0) {
            sb.append('\n');
            for (int i = 0; i < level; i++)
                sb.append(' ');
            sb.append('├').append('─');
        }

        if (node != null) {
            sb.append('(').append(' ').append(node.val).append(' ').append(')');

            if (node.left != null || node.right != null) {
                toTreeString(sb, node.left, level + 2);
                toTreeString(sb, node.right, level + 2);
            }

        } else {
            sb.append('(').append(' ').append('x').append(' ').append(')');
        }
    }

    @Override
    public String toString() {
        return "" + val + (left == null && right == null ? "" : ("(" + left + "^" + right + ")"));
    }

    public interface Builder {

        Builder left(TreeNode node);

        default Builder left(Builder node) { return left(node.build()); }

        default Builder left(int val) { return left(TreeNode.of(val)); }

        Builder right(TreeNode node);

        default Builder right(Builder node) { return right(node.build()); }

        default Builder right(int val) { return right(TreeNode.of(val)); }

        TreeNode build();
    }
}
