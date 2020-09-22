package org.gd.leetcode.p0366;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/find-leaves-of-binary-tree/
 */
@LeetCode(
        name = "Find Leaves Of Binary Tree",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.PAID,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.DEPTH_FIRST_SEARCH
        }
)
class Solution {

    private List<Integer> leaves;

    private void traverse(TreeNode node) {
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return;
        }

        if (node.left != null)
            traverse(node.left);

        if (node.right != null)
            traverse(node.right);
    }

    public List<Integer> findLeaves(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        leaves = new ArrayList<>();
        traverse(root);
        return leaves;
    }
}
