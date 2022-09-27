package org.gd.leetcode.p0919;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Horkhover Dmytro
 * @since 2022-09-27
 */
@LeetCode(
        name = "Complete Binary Tree Inserter",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.BREADTH_FIRST_SEARCH,
                LeetCode.Tags.DESIGN,
                LeetCode.Tags.BINARY_TREE
        }
)
class CBTInserter {

    private final TreeNode root;

    private TreeNode[] prev = new TreeNode[1], current = new TreeNode[2];
    private int prevI = 0, currentI = 0;

    public CBTInserter(TreeNode root) {
        if (root == null) {
            throw new NullPointerException("root");
        }
        this.root = prev[0] = new TreeNode(root.val);

        Queue<TreeNode> q = new LinkedList<>();
        if (root.left != null) {
            q.add(root.left);
        }
        if (root.right != null) {
            q.add(root.right);
        }
        while (!q.isEmpty() && !Thread.currentThread().isInterrupted()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                insert(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }
    }

    public int insert(int val) {
        if (currentI == current.length) {
            prev = current;
            current = new TreeNode[current.length << 1];
            prevI = currentI = 0;
        }

        TreeNode parent = prev[prevI];
        if (parent.left == null) {
            current[currentI++] = parent.left = new TreeNode(val);
            return parent.val;
        }

        current[currentI++] = parent.right = new TreeNode(val);
        prevI++;
        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
