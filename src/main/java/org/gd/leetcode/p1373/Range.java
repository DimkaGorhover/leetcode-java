package org.gd.leetcode.p1373;

import org.gd.leetcode.common.TreeNode;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-12
 */
class Range {

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

    boolean isRange(Result result) {
        return min <= result.left && result.right <= max;
    }

    boolean inRange(TreeNode node) {
        return inRange(node.val);
    }

    boolean inRange(int value) {
        return min <= value && value <= max;
    }
}
