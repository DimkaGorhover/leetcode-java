package org.gd.leetcode.p0700;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 *
 * @author Horkhover Dmytro
 * @since 2018-12-28
 */
@LeetCode(difficulty = LeetCode.Level.EASY)
class Solution {

    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val)
            root = root.val < val ? root.right : root.left;
        return root;
    }
}
