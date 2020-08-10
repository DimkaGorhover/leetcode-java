package org.gd.leetcode.p0700;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 *
 * @author Horkhover Dmytro
 * @since 2018-12-28
 */
@LeetCode(
        name = "Search in a Binary Search Tree",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.TREE,
                LeetCode.Tags.BINARY_SEARCH_TREE
        }
)
class Solution {

    public TreeNode searchBST(TreeNode root, final int val) {
        while (root != null && root.val != val)
            root = root.val < val ? root.right : root.left;
        return root;
    }
}
