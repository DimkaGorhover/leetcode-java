package org.gd.leetcode.p0341;

import java.util.List;

interface NestedInteger {

    static NestedInteger of(int value) { return new SingleValueNestedInteger(value); }

    static NestedInteger of(int... values) { return ListNestedInteger.of(values); }

    static NestedInteger of(NestedInteger... values) { return ListNestedInteger.of(values); }

    /**
     * @return true if this NestedInteger holds a single integer, rather than a nested list.
     */
    boolean isInteger();

    /**
     * @return the single integer that this NestedInteger holds, if it holds a single integer. Return null if this
     * NestedInteger holds a nested list
     */
    Integer getInteger();

    /**
     * @return the nested list that this NestedInteger holds, if it holds a nested list. Return null if this
     * NestedInteger holds a single integer
     */
    List<NestedInteger> getList();
}
