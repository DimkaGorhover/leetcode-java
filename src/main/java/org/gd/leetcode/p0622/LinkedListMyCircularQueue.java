package org.gd.leetcode.p0622;

import java.util.LinkedList;

public class LinkedListMyCircularQueue implements MyCircularQueue {

    private final LinkedList<Integer> q = new LinkedList<>();
    private final int capacity;

    LinkedListMyCircularQueue(int capacity) {
        this.capacity = capacity;
    }

    private int toInt(Integer value) {
        return value == null ? -1 : value;
    }

    public boolean enQueue(int value) {
        if (q.size() == capacity)
            return false;
        q.addLast(value);
        return true;
    }

    public boolean deQueue() {
        return q.pollFirst() != null;
    }

    public int Front() {
        return toInt(q.peekFirst());
    }

    public int Rear() {
        return toInt(q.peekLast());
    }

    public boolean isEmpty() {
        return q.size() == 0;
    }

    public boolean isFull() {
        return capacity == q.size();
    }

    public String toString() {
        return q.toString();
    }
}
