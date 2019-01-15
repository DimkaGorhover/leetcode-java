package org.gd.leetcode.p0114;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * TODO: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 *
 * @author Horkhover Dmytro
 * @since 2019-01-03
 */
@LeetCode(
        difficulty = LeetCode.Level.MEDIUM,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.DEPTH_FIRST_SEARCH
        })
class Solution {

    private TreeNode swap(TreeNode node, TreeNode right) {
        throw new UnsupportedOperationException();
    }

    public void flatten(TreeNode root) {
        if (root != null)
            swap(root, root.right);
    }
}
