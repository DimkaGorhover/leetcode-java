package org.gd.leetcode.p0117;

import org.gd.leetcode.common.LeetCode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0116.Solution
 * @since 2020-09-22
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Populating Next Right Pointers in Each Node II",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.DEPTH_FIRST_SEARCH,
                LeetCode.Tags.BREADTH_FIRST_SEARCH
        }
)
class Solution {

    public Node connect(Node root) {
        if (root == null)
            return null;

        Queue q = new Queue(root);

        while (q.hasElements()) {
            int size = q.size();
            Node prev = q.poll();
            for (int i = 0; i < size - 1; i++) {
                Node node = q.poll();
                prev.next = node;
                prev = node;
            }
        }
        return root;
    }

    static class Queue {

        private final LinkedList<Node> q = new LinkedList<>();

        Queue(Node node) {
            if (node == null)
                throw new NullPointerException("node");
            q.add(node);
        }

        int size() {
            return q.size();
        }

        boolean hasElements() {
            return !q.isEmpty();
        }

        Node poll() {
            if (q.isEmpty())
                return null;

            Node node = q.pollFirst();
            if (node.left != null)
                q.addLast(node.left);

            if (node.right != null)
                q.addLast(node.right);

            return node;
        }

        @Override
        public String toString() {
            return q.toString();
        }
    }
}
