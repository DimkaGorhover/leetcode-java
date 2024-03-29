package org.gd.leetcode.p0023;

class BigHeapSolutionFactory implements SolutionFactory {

    @SuppressWarnings("deprecation")
    @Override
    public Solution create() {
        return new BigHeapSolution();
    }

    @Override
    public String toString() {
        return "Big Heap";
    }
}
