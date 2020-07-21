package org.gd.leetcode.p0023;

class OopHeapSolutionFactory implements SolutionFactory {

    @Override
    public Solution create() {
        return new OopHeapSolution();
    }

    @Override
    public String toString() {
        return OopHeapSolution.class.getSimpleName();
    }
}
