package org.gd.leetcode.p0079;

/**
 * @author Horkhover D.
 * @since 2020-07-13.07.2020
 */
class PrototypeSolutionFactory implements SolutionFactory {

    @Override
    public Solution get() { return new Solution(); }

    @Override
    public String toString() { return "Prototype"; }
}
