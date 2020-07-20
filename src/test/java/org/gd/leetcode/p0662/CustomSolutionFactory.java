package org.gd.leetcode.p0662;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-20
 */
class CustomSolutionFactory implements SolutionFactory {

    @Override
    public Solution create() {
        return new CustomSolution();
    }

    @Override
    public String toString() {
        return CustomSolution.class.getSimpleName();
    }
}
