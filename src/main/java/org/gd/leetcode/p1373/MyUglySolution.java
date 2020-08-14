package org.gd.leetcode.p1373;

import org.gd.leetcode.common.TreeNode;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-12
 */
class MyUglySolution implements Solution {

    private int maxSum;

    public int maxSumBST(TreeNode root) {
        if (root == null)
            return 0;

        maxSum = 0;
        traverse(root, Range.INTEGER);
        return maxSum;
    }

    private static boolean isLeaf(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }

    private Result traverse(TreeNode root, Range range) {

        if (root == null)
            return Result.MISSING;

        if (isLeaf(root)) {
            maxSum = Math.max(maxSum, root.val);
            return new Result(root.val, range.inRange(root));
        }

        Result left = traverse(root.left, Range.leftOf(root));
        Result right = traverse(root.right, Range.rightOf(root));

        Result result = Result.merge(left, right, new Result(root.val));

        if (result.bst) {
            maxSum = Math.max(maxSum, result.sum);
            return result.filter(range);
        }

        return result;
    }

    static class Result {

        static final Result MISSING = new Result(0, 0, 0, true, true);

        final int sum;
        final int left;
        final int right;
        boolean bst;
        final boolean missing;

        Result(int sum) {
            this(sum, true);
        }

        Result(int sum, boolean bst) {
            this(sum, sum, sum, bst, false);
        }

        private Result(int sum, int left, int right, boolean bst, boolean missing) {
            this.sum = sum;
            this.left = left;
            this.right = right;
            this.bst = bst;
            this.missing = missing;
        }

        static Result merge(Result r1, Result r2, Result r3) {
            return merge(merge(r1, r2), r3);
        }

        static Result merge(Result r1, Result r2) {

            if (r1.missing) return r2;
            if (r2.missing) return r1;

            return new Result(
                    (r1.sum + r2.sum),
                    Math.min(r1.left, r2.left),
                    Math.max(r1.right, r2.right),
                    (r1.bst && r2.bst),
                    false);
        }

        Result filter(Range range) {
            bst = range.inRange(this);
            return this;
        }

        @Override
        public String toString() {

            if (missing)
                return "MISSING";

            return String.format("%d [%d <-> %d] %b", sum, left, right, bst);
        }
    }

    static class Range {

        public static final Range INTEGER = new Range(Integer.MIN_VALUE, Integer.MAX_VALUE);

        final int min, max;

        Range(int min, int max) {
            this.min = min;
            this.max = max;
        }

        static Range leftOf(TreeNode node) {
            return Range.INTEGER.left(node);
        }

        static Range rightOf(TreeNode node) {
            return Range.INTEGER.right(node);
        }

        Range left(TreeNode node) {
            return new Range(min, node.val - 1);
        }

        Range right(TreeNode node) {
            return new Range(node.val + 1, max);
        }

        boolean inRange(Result result) {
            return min <= result.left && result.right <= max;
        }

        boolean inRange(TreeNode node) {
            return inRange(node.val);
        }

        boolean inRange(int value) {
            return min <= value && value <= max;
        }

        @Override
        public String toString() {
            return String.format("[%d <-> %d]", min, max);
        }
    }
}
