package org.gd.leetcode.p0064;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import static java.util.Objects.requireNonNull;

/**
 * @author Horkhover D.
 * @since 2020-07-06.07.2020
 */
class PrototypeSolutionFactory implements SolutionFactory {

    private final MethodHandle constructor;
    private final String name;

    PrototypeSolutionFactory(Class<? extends ISolution> clazz) {
        requireNonNull(clazz, "\"clazz\" cannot be null");
        name = clazz.getSimpleName();
        try {
            var lookup = MethodHandles.lookup();
            constructor = lookup.findConstructor(clazz, MethodType.methodType(void.class));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ISolution get() {
        try {
            return (ISolution) constructor.invoke();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Prototype{" + name + "}";
    }
}
