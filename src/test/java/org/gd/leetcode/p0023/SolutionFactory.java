package org.gd.leetcode.p0023;

import java.util.function.Supplier;

interface SolutionFactory extends Supplier<Solution> {

    @Override
    default Solution get() { return create(); }

    Solution create();
}
