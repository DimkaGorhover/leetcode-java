package org.gd.leetcode.p0064;

import static java.util.Objects.requireNonNull;

/**
 * @author Horkhover D.
 * @since 2020-07-06.07.2020
 */
class SingletonSolutionFactory implements SolutionFactory {

    private final ISolution solution;
    private final String name;

    SingletonSolutionFactory(Class<? extends ISolution> clazz) {
        requireNonNull(clazz, "\"clazz\" cannot be null");
        solution = new PrototypeSolutionFactory(clazz).get();
        name = clazz.getSimpleName();
    }

    @Override
    public ISolution get() { return solution; }

    @Override
    public String toString() {
        return "Singleton{" + name + '}';
    }
}
