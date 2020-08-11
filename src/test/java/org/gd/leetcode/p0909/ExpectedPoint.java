package org.gd.leetcode.p0909;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-11
 */
class ExpectedPoint {

    final int row, col;

    ExpectedPoint(int row, int col) {
        this.row = row;
        this.col = col;
    }

    static ExpectedPoint of(Solution.Point point) {
        return new ExpectedPoint(point.row, point.col);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExpectedPoint)) return false;
        ExpectedPoint that = (ExpectedPoint) o;
        return row == that.row &&
                col == that.col;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
    }

    @Override
    public String toString() {
        return "row=" + row + " col=" + col;
    }
}
