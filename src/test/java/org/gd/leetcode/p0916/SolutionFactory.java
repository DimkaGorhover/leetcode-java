package org.gd.leetcode.p0916;

import java.util.function.Supplier;

/**
 * @author Horkhover D.
 * @since 2020-07-11
 */
interface SolutionFactory extends Supplier<Solution> {

    Solution create();

    @Override
    default Solution get() { return create(); }
}
