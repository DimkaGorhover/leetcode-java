package org.gd.leetcode.p0155;

import org.junit.jupiter.params.provider.Arguments;

import javax.annotation.Nonnull;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-27
 */
interface MinStackFactory extends Arguments {

    @Nonnull
    MinStack create();

    @Override
    default Object[] get() { return new Object[]{this}; }
}
