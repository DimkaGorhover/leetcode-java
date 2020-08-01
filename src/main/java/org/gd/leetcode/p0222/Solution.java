package org.gd.leetcode.p0222;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-02
 */
@LeetCode(
        name = "Count Complete Tree Nodes",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.BINARY_SEARCH,
                LeetCode.Tags.TREE
        }
)
class Solution {

    public int countNodes(TreeNode root) {
        return root == null ? 0 : 1 + countNodes(root.left) + countNodes(root.right);
    }
}
