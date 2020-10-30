package org.gd.leetcode.p0916;

/**
 * @author Horkhover D.
 * @since 2020-07-11
 */
class HashMapQuotaSolutionFactory implements SolutionFactory {

    @Override
    public Solution create() {
        return new HashMapQuotaSolution();
    }

    @Override
    public String toString() {
        return HashMapQuotaSolution.class.getSimpleName();
    }
}
