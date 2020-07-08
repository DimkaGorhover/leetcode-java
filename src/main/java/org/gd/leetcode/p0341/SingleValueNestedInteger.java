package org.gd.leetcode.p0341;

import java.util.List;

class SingleValueNestedInteger implements NestedInteger {

    private final int value;

    SingleValueNestedInteger(int value) {
        this.value = value;
    }

    @Override
    public Integer getInteger() {
        return value;
    }

    @Override
    public List<NestedInteger> getList() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isInteger() {
        return true;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
