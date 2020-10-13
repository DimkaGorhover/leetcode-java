package org.gd.leetcode.p0622;

class ArrayMyCircularQueueFactory implements MyCircularQueueFactory {

    @Override
    public MyCircularQueue create(int capacity) {
        return new ArrayMyCircularQueue(capacity);
    }

    @Override
    public String toString() {
        return "Array";
    }
}
