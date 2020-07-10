package org.gd.leetcode.p0120;

import java.util.function.Supplier;

interface SolutionFactory extends Supplier<ISolution> {

    ISolution create();

    @Override
    default ISolution get() { return create(); }
}
