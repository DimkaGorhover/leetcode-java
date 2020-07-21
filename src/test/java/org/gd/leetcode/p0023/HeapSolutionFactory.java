package org.gd.leetcode.p0023;

class HeapSolutionFactory implements SolutionFactory {

    @Override
    public Solution create() {
        return new HeapSolution();
    }

    @Override
    public String toString() {
        return HeapSolution.class.getSimpleName();
    }
}
