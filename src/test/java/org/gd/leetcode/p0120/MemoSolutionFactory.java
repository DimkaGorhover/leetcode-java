package org.gd.leetcode.p0120;

class MemoSolutionFactory implements SolutionFactory {

    @Override
    public ISolution create() {
        return new MemoSolution()::minimumTotal;
    }

    @Override
    public String toString() {
        return MemoSolution.class.getSimpleName();
    }
}
