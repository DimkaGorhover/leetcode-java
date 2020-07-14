package org.gd.leetcode.p0304;

interface SubCase {

    static Builder builder() { return new SubCaseBuilderImpl(); }

    void doAssert(NumMatrix numMatrix);

    void doAssert(Solution numMatrix);

    interface Builder {

        Builder setLeft(int row, int col);

        Builder setLeft(Bound left);

        Builder setRight(int row, int col);

        Builder setRight(Bound right);

        Builder setExpected(int expected);

        SubCase build();
    }
}
