package org.gd.leetcode.p0741;

public class PointImpl implements Point {

    private final int row, col;

    private int value;
    private int sum;
    private Point prev;
    private Boolean valid;

    PointImpl(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
        sum = value;
    }

    @Override
    public int value() { return value; }

    @Override
    public int pathSum() { return sum; }

    @Override
    public boolean isBlock() { return false; }

    @Override
    public boolean isValid() {
        if (valid != null)
            return valid;

        if (row == 0 && col == 0)
            return valid = true;

        if (prev != null)
            return valid = prev.isValid();

        return valid = false;
    }

    @Override
    public void addPrev(Point prev) {
        if (prev.isBlock()) return;
        reset();
        this.prev = prev;
        sum += prev.pathSum();
        isValid();
    }

    @Override
    public void reset() {
        sum = value;
        if (prev != null) {
            prev.reset();
            prev = null;
        }
    }

    @Override
    public void erase() {
        value = 0;
        sum = 0;
        if (prev != null) {
            prev.erase();
            prev = null;
        }
    }

    @Override
    public String path() {
        String s = String.format("(%d;%d)", row, col);
        if (prev != null)
            s = String.format("%s->%s", prev.path(), s);
        return s;
    }

    @Override
    public String toString() { return "" + value; }
}
