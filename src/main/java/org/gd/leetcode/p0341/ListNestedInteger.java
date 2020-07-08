package org.gd.leetcode.p0341;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ListNestedInteger implements NestedInteger {

    private final List<NestedInteger> list;

    private ListNestedInteger(List<NestedInteger> list) {
        this.list = list;
    }

    static NestedInteger of(int... values) {
        List<NestedInteger> list = new ArrayList<>();
        for (int value : values)
            list.add(new SingleValueNestedInteger(value));
        return new ListNestedInteger(list);
    }

    static NestedInteger of(NestedInteger... values) {
        return new ListNestedInteger(Arrays.asList(values));
    }

    @Override
    public Integer getInteger() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }

    @Override
    public boolean isInteger() {
        return false;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
