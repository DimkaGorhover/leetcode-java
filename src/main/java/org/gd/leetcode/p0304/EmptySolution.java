package org.gd.leetcode.p0304;

/**
 * @author Horkhover D.
 * @since 2020-07-14
 */
class EmptySolution implements Solution {

    static final EmptySolution INSTANCE = new EmptySolution();

    private EmptySolution() {}

    @Override
    public int sumRegion(int row1, int col1, int row2, int col2) { return 0; }

    @Override
    public String toString() { return "EmptySolution"; }
}
