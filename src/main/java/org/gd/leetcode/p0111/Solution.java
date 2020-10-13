package org.gd.leetcode.p0111;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * @author Horkhover Dmytro
 * @since 2019-02-12
 */
@LeetCode(
        name = "Minimum Depth of Binary Tree",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.DEPTH_FIRST_SEARCH,
                LeetCode.Tags.BREADTH_FIRST_SEARCH
        })
class Solution {

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return 1 + Math.min(
                root.left == null ? Integer.MAX_VALUE : minDepth(root.left),
                root.right == null ? Integer.MAX_VALUE : minDepth(root.right)
        );
    }
}
