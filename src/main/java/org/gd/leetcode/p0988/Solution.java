package org.gd.leetcode.p0988;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/smallest-string-starting-from-leaf/
 */
@LeetCode(
        name = "Smallest String Starting From Leaf",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.DEPTH_FIRST_SEARCH
        }
)
class Solution {

    private Queue<TNode> q;

    private void traverse(TNode parent, TreeNode treeNode) {
        TNode node = new TNode(parent, treeNode.val);
        if (treeNode.left == null && treeNode.right == null) {
            q.add(node);
            return;
        }

        if (treeNode.left != null)
            traverse(node, treeNode.left);

        if (treeNode.right != null)
            traverse(node, treeNode.right);
    }

    @SuppressWarnings("ConstantConditions")
    public String smallestFromLeaf(TreeNode root) {
        if (root == null)
            return null;

        q = new PriorityQueue<>();
        traverse(null, root);
        return q.peek().toString();
    }
}
