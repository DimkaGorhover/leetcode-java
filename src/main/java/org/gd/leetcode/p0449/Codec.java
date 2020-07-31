package org.gd.leetcode.p0449;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0297.Codec
 * @since 2020-07-31
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Serialize and Deserialize BST",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.DESIGN
        }
)
class Codec {

    static int size(TreeNode root) {
        return root == null ? 0 : 1 + size(root.left) + size(root.right);
    }

    /**
     * Encodes a tree to a single string.
     */
    public String serialize(TreeNode root) {
        if (root == null)
            return null;
        return Nodes.of(root).toString();
    }

    /**
     * Decodes your encoded data to tree.
     */
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty())
            return null;
        return Nodes.of(data).toTree();
    }

    @SuppressWarnings("EnhancedSwitchMigration")
    static class Nodes {

        private final Codec.Node[] nodes;
        private int size = 0;
        private int nextId = 0;

        private Nodes(Codec.Node[] nodes) {
            this.nodes = nodes;
            for (Codec.Node node : nodes) {
                if (node != null)
                    size++;
            }
        }

        private Nodes(TreeNode treeNode) {
            nodes = new Codec.Node[size(treeNode)];
            fill('p', treeNode, null);
        }

        static Nodes of(Codec.Node... nodes) {
            return new Nodes(nodes);
        }

        static Nodes of(TreeNode treeNode) {
            return new Nodes(treeNode);
        }

        static Nodes of(String text) {
            return new NodesReader(text).read();
        }

        private void fill(char side, TreeNode treeNode, Codec.Node parent) {
            if (treeNode != null) {
                int id = nextId++;
                size++;
                nodes[id] = new Codec.Node(side, id, (parent == null ? -1 : parent.id), treeNode);
                fill('l', treeNode.left, nodes[id]);
                fill('r', treeNode.right, nodes[id]);
            }
        }

        TreeNode toTree() {
            for (int i = 1; i < size; i++) {
                Codec.Node node = nodes[i];
                TreeNode treeNode = node.treeNode;
                if (node.parentId >= 0) {
                    TreeNode parent = nodes[node.parentId].treeNode;
                    switch (node.side) {
                        case 'l':
                            parent.left = treeNode;
                            break;
                        case 'r':
                            parent.right = treeNode;
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                }
            }
            return nodes[0].treeNode;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(nodes.length).append('|');
            nodes[0].writeString(sb);
            for (int i = 1; i < nodes.length; i++)
                nodes[i].writeString(sb.append(';'));
            return sb.toString();
        }
    }

    static class Node {

        final char side;
        final int id;
        final int parentId;
        final TreeNode treeNode;

        Node(char side, int id, int parentId, TreeNode treeNode) {
            this.side = side;
            this.id = id;
            this.parentId = parentId;
            this.treeNode = treeNode;
        }

        Node(char side, int id, int parentId, int value) {
            this.side = side;
            this.id = id;
            this.parentId = parentId;
            this.treeNode = new TreeNode(value);
        }

        void writeString(StringBuilder sb) {
            sb.append(side).append(':')
                    .append(id).append(':')
                    .append(parentId).append(':')
                    .append(treeNode.val);
        }
    }

    static class NodesReader {

        private final String text;

        private int cursor;

        NodesReader(String text) {
            this.text = text;
        }

        private static boolean isDigit(char c) {
            return '0' <= c && c <= '9';
        }

        private static int digit(char c) {
            return c - '0';
        }

        char next() {
            if (cursor >= text.length())
                throw new IndexOutOfBoundsException();

            char c = text.charAt(cursor);
            cursor++;
            return c;
        }

        int nextInt() {
            if (cursor >= text.length())
                throw new IndexOutOfBoundsException();

            int s = 1;
            boolean readS = false;
            int num = 0;
            while (cursor < text.length()) {
                char c = text.charAt(cursor);
                if (c == '-') {
                    if (readS)
                        throw new IllegalArgumentException();
                    s = -1;
                    readS = true;
                } else if (isDigit(c)) {
                    readS = true;
                    num = num * 10 + digit(c);
                } else {
                    break;
                }
                cursor++;
            }
            return num * s;
        }

        Nodes read() {
            int length = nextInt();
            cursor++;
            Codec.Node[] nodes = new Codec.Node[length];
            for (int i = 0; i < length; i++) {
                char side = next();
                cursor++;
                int id = nextInt();
                cursor++;
                int parentId = nextInt();
                cursor++;
                int value = nextInt();
                cursor++;
                nodes[id] = new Codec.Node(side, id, parentId, value);
            }
            return Nodes.of(nodes);
        }
    }
}
