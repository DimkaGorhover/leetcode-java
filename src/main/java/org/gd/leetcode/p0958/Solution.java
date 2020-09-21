package org.gd.leetcode.p0958;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 *
 * @author Horkhover Dmytro
 * @since 2020-09-21
 */
@LeetCode(
        name = "Check Completeness of a Binary Tree",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.BREADTH_FIRST_SEARCH
        }
)
class Solution {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null)
            return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean foundNull = false;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                if (node == null) {
                    foundNull = true;
                    continue;
                }

                if (foundNull) {
                    return false;
                }

                q.add(node.left);
                q.add(node.right);
            }
        }

        return true;
    }
}
