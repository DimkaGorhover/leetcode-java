package org.gd.leetcode.p1315;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 *
 * @author Horkhover Dmytro
 * @since 2020-09-22
 */
@LeetCode(
        name = "Nodes with Even-Valued Grandparent",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.DEPTH_FIRST_SEARCH
        }
)
class Solution {

    private int sum;

    private void traverse(TreeNode grand, TreeNode parent, TreeNode node) {
        if (node == null)
            return;

        if (grand != null && grand.val % 2 == 0)
            sum += node.val;

        traverse(parent, node, node.left);
        traverse(parent, node, node.right);
    }

    public int sumEvenGrandparent(TreeNode root) {
        sum = 0;
        traverse(null, null, root);
        return sum;
    }
}
