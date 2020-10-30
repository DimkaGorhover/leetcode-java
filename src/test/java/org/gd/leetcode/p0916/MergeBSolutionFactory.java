package org.gd.leetcode.p0916;

/**
 * @author Horkhover D.
 * @since 2020-07-11
 */
class MergeBSolutionFactory implements SolutionFactory {

    @Override
    public Solution create() {
        return new MergeBSolution();
    }

    @Override
    public String toString() {
        return MergeBSolution.class.getSimpleName();
    }
}
