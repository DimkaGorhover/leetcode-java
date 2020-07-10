package org.gd.leetcode.p0641;

import java.util.Arrays;

class ArrayMyCircularDeque implements MyCircularDeque {

    private final int[] arr;

    private int size = 0;

    ArrayMyCircularDeque(int capacity) {
        arr = new int[capacity];
    }

    public boolean insertFront(int value) {
        if (isFull())
            return false;
        size++;
        System.arraycopy(arr, 0, arr, 1, size - 1);
        arr[0] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull())
            return false;

        arr[size] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty())
            return false;
        System.arraycopy(arr, 1, arr, 0, size - 1);
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty())
            return false;
        size--;
        return true;
    }

    public int getFront() { return isEmpty() ? -1 : arr[0]; }

    public int getRear() {
        return isEmpty() ? -1 : arr[size - 1];
    }

    public boolean isEmpty() { return size == 0; }

    public boolean isFull() { return size == arr.length; }

    @Override
    public String toString() {
        if (isEmpty())
            return "[]";

        if (isFull())
            return Arrays.toString(arr);

        return Arrays.toString(Arrays.copyOf(arr, size));
    }
}
