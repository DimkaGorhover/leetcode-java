package org.gd.leetcode.p0155;

import org.junit.jupiter.params.provider.Arguments;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-27
 */
interface MinStackFactory extends Arguments {

    MinStack create();

    @Override
    default Object[] get() { return new Object[]{this}; }
}
