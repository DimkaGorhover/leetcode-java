package org.gd.leetcode.p0120;

class SolutionFactoryImpl implements SolutionFactory {

    @Override
    public ISolution create() {
        return new Solution()::minimumTotal;
    }

    @Override
    public String toString() {
        return Solution.class.getSimpleName();
    }
}
