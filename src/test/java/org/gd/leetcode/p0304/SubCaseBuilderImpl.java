package org.gd.leetcode.p0304;

import static java.util.Objects.requireNonNull;

/**
 * @since 2019-10-07
 */
class SubCaseBuilderImpl implements SubCase.Builder {

    private Bound left;
    private Bound right;
    private int expected;

    SubCaseBuilderImpl() {}

    @Override
    public SubCase.Builder setLeft(int row, int col) {
        return setLeft(Bound.of(row, col));
    }

    @Override
    public SubCase.Builder setLeft(Bound left) {
        this.left = left;
        return this;
    }

    @Override
    public SubCase.Builder setRight(int row, int col) {
        return setRight(Bound.of(row, col));
    }

    @Override
    public SubCase.Builder setRight(Bound right) {
        this.right = right;
        return this;
    }

    @Override
    public SubCase.Builder setExpected(int expected) {
        this.expected = expected;
        return this;
    }

    @Override
    public SubCase build() {
        requireNonNull(left, "\"left\" cannot be null");
        requireNonNull(right, "\"right\" cannot be null");
        return new SubCaseImpl(left, right, expected);
    }
}
