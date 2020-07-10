package org.gd.leetcode.p0622;

import java.util.Arrays;

class ArrayMyCircularQueue implements MyCircularQueue {

    private final int[] arr;
    private int size = 0;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    ArrayMyCircularQueue(int k) {
        arr = new int[k];
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull())
            return false;

        arr[size] = value;
        size++;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (size > 0) {
            System.arraycopy(arr, 1, arr, 0, size - 1);
            size--;
            return true;
        }

        return false;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        return isEmpty() ? -1 : arr[0];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        return isEmpty() ? -1 : arr[size - 1];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return size == arr.length;
    }

    public String toString() {
        return Arrays.toString(Arrays.copyOf(arr, size));
    }
}
