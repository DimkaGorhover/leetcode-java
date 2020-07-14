package org.gd.leetcode.p0304;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @since 2019-10-07
 */
class SubCaseImpl implements SubCase {

    private final Bound left, right;
    private final int expected;

    SubCaseImpl(Bound left, Bound right, int expected) {
        this.left = left;
        this.right = right;
        this.expected = expected;
    }

    @Override
    public void doAssert(NumMatrix numMatrix) {
        requireNonNull(numMatrix, "\"numMatrix\" cannot be null");
        doAssert(numMatrix::sumRegion);
    }

    @Override
    public void doAssert(Solution numMatrix) {
        requireNonNull(numMatrix, "\"numMatrix\" cannot be null");
        assertEquals(
                expected,
                numMatrix.sumRegion(left.row, left.col, right.row, right.col),
                this::toString);
    }

    @Override
    public String toString() {
        return String.format("[%s:%s)] --> %d", left, right, expected);
    }
}
