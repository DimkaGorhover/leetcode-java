package org.gd.leetcode.p0662;

import java.util.function.Supplier;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-20
 */
interface SolutionFactory extends Supplier<Solution> {

    Solution create();

    @Override
    default Solution get() { return create(); }
}
