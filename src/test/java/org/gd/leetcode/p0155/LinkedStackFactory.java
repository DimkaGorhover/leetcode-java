package org.gd.leetcode.p0155;

import javax.annotation.Nonnull;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-27
 */
class LinkedStackFactory implements MinStackFactory {

    @Nonnull
    @Override
    public MinStack create() {
        return new LinkedMinStack();
    }

    @Override
    public String toString() {
        return "LinkedStack";
    }
}
