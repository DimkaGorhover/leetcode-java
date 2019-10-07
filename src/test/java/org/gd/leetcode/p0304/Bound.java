package org.gd.leetcode.p0304;

/**
 * @since 2019-10-07
 */
class Bound {

    final int row, col;

    private Bound(int row, int col) {
        this.row = row;
        this.col = col;
    }

    static Bound of(int row, int col) {
        return new Bound(row, col);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bound)) return false;
        Bound bound = (Bound) o;
        return row == bound.row &&
                col == bound.col;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
    }

    @Override
    public String toString() {
        return String.format("(%d:%d)", row, col);
    }
}
