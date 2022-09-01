package org.gd.leetcode.p0235;

import org.gd.leetcode.common.Repeat;
import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/discuss/64963/3-lines-with-O(1)-space-1-Liners-Alternatives
 *
 * @author Gorkhover D.
 * @see org.gd.leetcode.p0236.Solution
 * @see org.gd.hackerrank.other.tree.LowestCommonAncestor
 * @since 2018-10-17
 */
@SuppressWarnings("JavadocReference")
@Repeat("binary tree Lowest Common Ancestor")
@LeetCode(
        name = "Lowest Common Ancestor of a Binary Search Tree",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.TREE
)
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode left, TreeNode right) {
        if (left.val > right.val)
            return lowestCommonAncestor(root, right, left);

        while (root != null && (root.val > right.val || root.val < left.val))
            root = root.val > right.val ? root.left : root.right;

        return root;
    }
}
