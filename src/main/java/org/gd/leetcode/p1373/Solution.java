package org.gd.leetcode.p1373;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0098.Solution
 * @since 2020-08-12
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Maximum Sum BST in Binary Tree",
        difficulty = LeetCode.Level.HARD,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.DYNAMIC_PROGRAMMING,
                LeetCode.Tags.BINARY_SEARCH_TREE
        }
)
class Solution {

    private int maxSum;

    private Result traverse(TreeNode root, final long min, final long max) {

        if (root == null)
            return ResultImpl.ZERO;

        if (root.left == null && root.right == null) {
            maxSum = Math.max(maxSum, root.val);
            if ((min >= root.val) || (root.val >= max))
                return NotValid.INSTANCE;
            return new ResultImpl(root.val);
        }








        Result left = traverse(root.left, Integer.MIN_VALUE, root.val);
        Result right = traverse(root.right, root.val, Integer.MAX_VALUE);
        if (left.valid() && right.valid()) {
            int sum = root.val + left.sum() + right.sum();
            maxSum = Math.max(maxSum, sum);
        }








        left = traverse(root.left, min, root.val);
        right = traverse(root.right, root.val, max);
        if (left.valid() && right.valid()) {
            return new ResultImpl(root.val + left.sum() + right.sum());
        }

        return NotValid.INSTANCE;
    }

    public int maxSumBST(TreeNode root) {
        if (root == null)
            return 0;

        maxSum = Integer.MIN_VALUE;
        traverse(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return Math.max(0, maxSum);
    }

}
