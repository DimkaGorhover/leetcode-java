package org.gd.leetcode.p1373;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-12
 */
class ResultImpl implements Result {

    public static final ResultImpl ZERO = new ResultImpl(0);

    private final int sum;

    ResultImpl(int sum) { this.sum = sum; }

    @Override
    public String toString() { return sum + ""; }

    @Override
    public boolean valid() { return true; }

    @Override
    public int sum() { return sum; }
}
