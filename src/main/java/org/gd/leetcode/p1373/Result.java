package org.gd.leetcode.p1373;

import static java.util.Objects.requireNonNull;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-12
 */
class Result {

    static final Result ZERO = new Result(0);

    final int sum;
    final int left;
    final int right;
    final boolean bst;

    Result(int sum) {
        this(sum, true);
    }

    Result(int sum, boolean bst) {
        this(sum, sum, sum, bst);
    }

    Result(int sum, int left, int right, boolean bst) {
        this.sum = sum;
        this.left = left;
        this.right = right;
        this.bst = bst;
    }

    static Result merge(Result r1, Result r2) {
        requireNonNull(r1, "\"r1\" cannot be null");
        requireNonNull(r2, "\"r2\" cannot be null");
        return new Result(
                (r1.sum + r2.sum),
                Math.min(r1.left, r2.left),
                Math.max(r1.right, r2.right),
                (r1.bst && r2.bst));
    }

    @Override
    public String toString() { return sum + ""; }
}
