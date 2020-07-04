package org.gd.leetcode.p1339;

import org.gd.leetcode.common.LeetCode;
import org.gd.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
 */
@LeetCode(
        name = "Maximum Product of Splitted Binary Tree",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.DYNAMIC_PROGRAMMING,
                LeetCode.Tags.TREE,
                LeetCode.Tags.DEPTH_FIRST_SEARCH
        })
class Solution {

    private static final long MODULO = (long) (1e9 + 7);

    private final Map<TreeNode, Long> sums = new HashMap<>();

    private long sumAll;
    private long product = Integer.MIN_VALUE;

    private long sumRecursive(TreeNode node) {
        if (node == null)
            return 0;

        long sum = node.val + sumRecursive(node.left) + sumRecursive(node.right);
        sums.put(node, sum);
        return sum;
    }

    private long sumCached(TreeNode node) {
        return node == null ? 0 : sums.get(node);
    }

    private void calcMaxProduct(TreeNode root) {
        if (root == null)
            return;
        long sum = sumCached(root);
        product = Math.max(product, (sumAll - sum) * sum);
    }

    private void traverseCalcMaxProduct(TreeNode root) {
        if (root == null)
            return;

        calcMaxProduct(root.left);
        calcMaxProduct(root.right);

        traverseCalcMaxProduct(root.left);
        traverseCalcMaxProduct(root.right);
    }

    public int maxProduct(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.val;
        sumAll = sumRecursive(root);
        traverseCalcMaxProduct(root);
        return (int) (product % MODULO);
    }
}

/*
class Solution {

    long res = 0;

    public int maxProduct(TreeNode root) {

        long total = sum(root, 0);

        sum(root, total);
        return (int)(res%(1_000_000_007));
    }

    long sum(TreeNode n, long total) {

        if (n == null)
            return 0L;

        long s = sum(n.left, total) + sum(n.right, total) + n.val;

        res = Math.max(res, (total - s)*s);
        return s;
    }
}
 */