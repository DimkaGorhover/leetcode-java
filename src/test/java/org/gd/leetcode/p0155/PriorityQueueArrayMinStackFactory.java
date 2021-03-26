package org.gd.leetcode.p0155;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-27
 */
class PriorityQueueArrayMinStackFactory implements MinStackFactory {

    @Override
    public MinStack create() {
        return new PriorityQueueArrayMinStack();
    }

    @Override
    public String toString() {
        return "Heap";
    }
}
