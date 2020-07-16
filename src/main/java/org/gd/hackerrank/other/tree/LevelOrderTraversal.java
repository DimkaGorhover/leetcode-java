package org.gd.hackerrank.other.tree;

import org.gd.hackerrank.common.HackerRank;

import java.util.StringJoiner;

/**
 * https://www.hackerrank.com/challenges/tree-level-order-traversal/
 *
 * @author Horkhover D.
 * @since 2020-07-15
 */
@HackerRank(difficulty = HackerRank.Level.EASY)
class LevelOrderTraversal {

    private LevelOrderTraversal() { throw new UnsupportedOperationException(); }

    private static int height(Node root) {
        return root == null ? 0 : 1 + Math.max(height(root.left), height(root.right));
    }

    private static void traverse(LLNode[] llNodes, Node node, int level) {
        if (node == null)
            return;
        llNodes[level] = new LLNode(node.data, llNodes[level]);
        traverse(llNodes, node.right, level + 1);
        traverse(llNodes, node.left, level + 1);
    }

    public static void levelOrder(Node root) {
        if (root == null)
            return;

        LLNode[] llNodes = new LLNode[height(root)];
        traverse(llNodes, root, 0);

        StringJoiner sj = new StringJoiner(" ");
        for (LLNode llNode : llNodes)
            llNode.writeTo(sj);

        System.out.println(sj.toString());
    }

    static class LLNode {
        private final int data;
        private final LLNode next;

        LLNode(int data, LLNode next) {
            this.data = data;
            this.next = next;
        }

        public void writeTo(StringJoiner sj) {
            sj.add("" + data);
            if (next != null)
                next.writeTo(sj);
        }
    }
}
