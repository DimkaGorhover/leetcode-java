package org.gd.leetcode.p0662;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-20
 */
class TwoListsSolutionFactory implements SolutionFactory {

    @Override
    public Solution create() {
        return new TwoListsSolution();
    }

    @Override
    public String toString() {
        return TwoListsSolution.class.getSimpleName();
    }
}
