package org.gd.leetcode.p0079;

/**
 * @author Horkhover D.
 * @since 2020-07-13
 */
class SingletonSolutionFactory implements SolutionFactory {

    private final Solution solution = new Solution();

    @Override
    public Solution get() { return solution; }

    @Override
    public String toString() { return "Singleton"; }
}
