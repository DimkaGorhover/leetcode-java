package org.gd.leetcode.p0741;

class SimplePoint {

    private int value;
    private int sum;
    private SimplePoint prev;

    SimplePoint(int value) { this.value = sum = value; }

    int value() { return value; }

    int pathSum() { return sum; }

    boolean isBlock() { return value == -1; }

    void addPrev(SimplePoint prev) {
        if (prev.value == -1)
            return;

        this.prev = prev;
        sum += prev.pathSum();
    }

    void resetAll() {
        sum = value = 0;
        if (prev != null) {
            prev.resetAll();
            prev = null;
        }
    }

    @Override
    public String toString() {
        String s = String.format("(%s)", value == -1 ? "block" : value);
        if (prev != null)
            s = String.format("%s->%s", prev.toString(), s);
        return s;
    }
}
