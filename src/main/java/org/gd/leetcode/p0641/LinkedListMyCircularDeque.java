package org.gd.leetcode.p0641;

import java.util.LinkedList;

@SuppressWarnings("ConstantConditions")
class LinkedListMyCircularDeque implements MyCircularDeque {

    private final LinkedList<Integer> q = new LinkedList<>();
    private final int capacity;

    LinkedListMyCircularDeque(int capacity) {
        this.capacity = capacity;
    }

    public boolean insertFront(int value) {
        if (isFull())
            return false;
        q.offerFirst(value);
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull())
            return false;
        q.offerLast(value);
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty())
            return false;
        q.pollFirst();
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty())
            return false;
        q.pollLast();
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : q.peekFirst();
    }

    public int getRear() {
        return isEmpty() ? -1 : q.peekLast();
    }

    public boolean isEmpty() {
        return q.size() == 0;
    }

    public boolean isFull() {
        return q.size() == capacity;
    }

    public String toString() {
        return q.toString();
    }
}
