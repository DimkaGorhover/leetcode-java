package org.gd.leetcode.p0741;

interface Point {

    static Point of(int row, int col, int value) {
        return value == -1 ? BlockPoint.INSTANCE : new PointImpl(row, col, value);
    }

    int value();

    int pathSum();

    boolean isBlock();

    boolean isValid();

    void addPrev(Point prev);

    void reset();

    void erase();

    String path();

}
