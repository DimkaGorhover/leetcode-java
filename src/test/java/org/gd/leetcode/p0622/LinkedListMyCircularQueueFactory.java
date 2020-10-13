package org.gd.leetcode.p0622;

class LinkedListMyCircularQueueFactory implements MyCircularQueueFactory {

    @Override
    public MyCircularQueue create(int capacity) {
        return new LinkedListMyCircularQueue(capacity);
    }

    @Override
    public String toString() {
        return "Linked List";
    }
}
