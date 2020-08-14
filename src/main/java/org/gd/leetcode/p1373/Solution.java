package org.gd.leetcode.p1373;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/maximum-sum-bst-in-binary-tree
 *
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

    private static boolean isLeaf(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }

    private Result traverse(TreeNode root, Range range) {

        if (root == null)
            return Result.ZERO;

        if (isLeaf(root)) {
            maxSum = Math.max(maxSum, root.val);
            return new Result(root.val, range.inRange(root));
        }

        Result left = traverse(root.left, Range.leftOf(root));
        Result right = traverse(root.right, Range.rightOf(root));

        if (left.bst && right.bst) {

            Result child = Result.merge(left, right);
            Result result = Result.merge(child, new Result(root.val));

            maxSum = Math.max(maxSum, result.sum);


        }









        if (left.bst && right.bst) {
            int sum = root.val + left.sum + right.sum;
            maxSum = Math.max(maxSum, sum);
        }


        left = traverse(root.left, range.left(root));
        right = traverse(root.right, range.right(root));
        if (left.bst && right.bst) {
            return new Result(root.val + left.sum + right.sum);
        }

        return Result.ZERO;
    }

    public int maxSumBST(TreeNode root) {
        if (root == null)
            return 0;

        maxSum = 0;
        traverse(root, Range.INTEGER);
        return maxSum;
    }

}
