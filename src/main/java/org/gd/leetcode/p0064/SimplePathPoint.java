package org.gd.leetcode.p0064;

/**
 * @author Horkhover D.
 * @since 2020-07-05
 */
class SimplePathPoint extends AbstractPathPoint {

    SimplePathPoint(int[][] grid, PathPoint prev, int row, int col) {
        super(grid, prev, row, col);
    }

    static SimplePathPoint start(int[][] grid) {
        return new SimplePathPoint(grid, null, 0, 0);
    }
}
