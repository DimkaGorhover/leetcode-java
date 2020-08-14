package org.gd.leetcode.p1373;

import org.gd.leetcode.common.TreeNode;

class ReferenceSolution implements Solution {

    private int max = 0;

    public int maxSumBST(TreeNode root) {

        if (root == null)
            return 0;

        dfs(root);
        return max;
    }

    private int[] dfs(TreeNode node) {

        if (node == null)
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        if (!(left != null && right != null && node.val > left[1] && node.val < right[0]))
            return null;

        int sum = node.val + left[2] + right[2];

        max = Math.max(max, sum);

        int min = Math.min(node.val, left[0]);
        int max = Math.max(node.val, right[1]);

        return new int[]{min, max, sum};
    }
}
