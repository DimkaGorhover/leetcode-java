package org.gd.leetcode.p0641;

class ArrayQFactory implements QFactory {

    @Override
    public MyCircularDeque create(int capacity) {
        return new ArrayMyCircularDeque(capacity);
    }

    @Override
    public String toString() {
        return ArrayMyCircularDeque.class.getSimpleName();
    }
}
