package org.gd.leetcode.p0155;

import javax.annotation.Nonnull;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-27
 */
class PriorityQueueArrayMinStackFactory implements MinStackFactory {

    @SuppressWarnings("deprecation")
    @Nonnull
    @Override
    public MinStack create() {
        return new PriorityQueueArrayMinStack();
    }

    @Override
    public String toString() {
        return "Heap";
    }
}
