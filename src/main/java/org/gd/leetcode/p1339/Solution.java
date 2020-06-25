package org.gd.leetcode.p1339;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * TODO: https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
 */
@LeetCode(
    difficulty = LeetCode.Level.MEDIUM,
    tags = {
        LeetCode.Tags.DYNAMIC_PROGRAMMING,
        LeetCode.Tags.TREE,
        LeetCode.Tags.DEPTH_FIRST_SEARCH
    })
class Solution {
    
    public int maxProduct(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.val;

        throw new UnsupportedOperationException();
    }
}
