package org.gd.leetcode.p0641;

class LinkedListQFactory implements QFactory {

    @Override
    public MyCircularDeque create(int capacity) {
        return new LinkedListMyCircularDeque(capacity);
    }

    @Override
    public String toString() {
        return LinkedListMyCircularDeque.class.getSimpleName();
    }
}
