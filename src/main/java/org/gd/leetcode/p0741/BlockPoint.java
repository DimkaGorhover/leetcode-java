package org.gd.leetcode.p0741;

public class BlockPoint implements Point {

    static final org.gd.leetcode.p0741.BlockPoint INSTANCE = new org.gd.leetcode.p0741.BlockPoint();

    private BlockPoint() {}

    @Override
    public int value() { return -1; }

    @Override
    public int pathSum() {
        throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
    }

    @Override
    public boolean isBlock() { return true; }

    @Override
    public boolean isValid() { return false; }

    @Override
    public void addPrev(Point prev) {
        throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
    }

    @Override
    public void reset() {}

    @Override
    public void erase() {}

    @Override
    public String path() { return ""; }

    @Override
    public String toString() { return "(block)"; }
}
