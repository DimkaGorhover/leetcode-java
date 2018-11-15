package org.gd.leetcode.p0129;

import org.gd.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 *
 * @author Horkhover Dmytro
 * @since 2018-11-15
 */
class Solution {

    private static int number(TreeNode root, int prev, int sum) {
        if (root.left == null && root.right == null)
            return sum + prev;
        if (root.left != null)
            sum = number(root.left, prev * 10 + root.left.val, sum);
        if (root.right != null)
            sum = number(root.right, prev * 10 + root.right.val, sum);
        return sum;

    }

    public int sumNumbers(TreeNode root) {
        return root == null ? 0 : number(root, root.val, 0);
    }
}
