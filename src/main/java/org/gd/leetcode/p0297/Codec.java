package org.gd.leetcode.p0297;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

/**
 * TODO: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *
 * @since 2019-09-12
 */
@LeetCode(difficulty = LeetCode.Level.HARD, tags = {LeetCode.Tags.TREE, LeetCode.Tags.DESIGN})
class Codec {

    @Deprecated
    static int size(TreeNode root) {
        return root == null ? 0 : 1 + size(root.left) + size(root.right);
    }

    /** Encodes a tree to a single string. */
    public String serialize(TreeNode root) {

        List<Node> nodes = Node.of(root);
        IntBuffer bb = IntBuffer.allocate(nodes.size() * 3);
        
        
        nodes.forEach(node -> System.out.println(node));
        nodes.forEach(node -> node.writeTo(bb));

        String text = Arrays.toString(bb.array());

        System.out.println(text);


        throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
    }

    /** Decodes your encoded data to tree. */
    public TreeNode deserialize(String data) {
        throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
    }

    static class Node {

        static final int OBJECT_SIZE = Integer.BYTES * 3;

        int id;
        int parentId;
        int value;

        static List<Node> of(TreeNode treeNode) {
            return of(new ArrayList<>(), treeNode, 0, null);
        }

        static List<Node> of(List<Node> nodes, TreeNode treeNode, int id, Node parent) {
            if (treeNode != null) {

                Node node = new Node();
                node.id = id;
                node.parentId = parent == null ? -1 : parent.id;
                node.value = treeNode.val;
    
                nodes.add(node);

                of(nodes, treeNode.left, id + 1, node);
                of(nodes, treeNode.right, id + 2, node);
            }

            return nodes;
        }

        void writeTo(ByteBuffer bb) {
            writeTo(bb.asIntBuffer());
        }

        void writeTo(IntBuffer bb) {
            bb.put(id);
            bb.put(parentId);
            bb.put(value);
        }

        @Override
        public String toString() {
            return String.format("( id:%d; value:%d; parent:%d )", id, value, parentId);
        }
    }
}
