package org.gd.leetcode.p0064;

import java.util.function.Supplier;

/**
 * @author Horkhover D.
 * @since 2020-07-06.07.2020
 */
interface SolutionFactory extends Supplier<ISolution> {

    static SolutionFactory singleton(Class<? extends ISolution> clazz) {
        return new SingletonSolutionFactory(clazz);
    }

    static SolutionFactory prototype(Class<? extends ISolution> clazz) {
        return new PrototypeSolutionFactory(clazz);
    }
}
