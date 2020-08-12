package org.gd.leetcode.p1302;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/deepest-leaves-sum/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-12
 */
@SuppressWarnings("ConstantConditions")
@LeetCode(
        name = "Deepest Leaves Sum",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.DEPTH_FIRST_SEARCH
        }
)
class Solution {

    public int deepestLeavesSum(TreeNode root) {

        if (root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            res = 0;
            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                res += node.val;

                if (node.left != null)
                    q.add(node.left);

                if (node.right != null)
                    q.add(node.right);
            }
        }
        return res;
    }
}
