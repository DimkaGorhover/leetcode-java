package org.gd.leetcode.p0480;

import java.util.Arrays;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-22
 */
class SortedList implements SlidingWindow {

    private final long[] arr;
    private int size = 0;

    SortedList(int[] nums, int k) {
        arr = new long[k];
        for (int i = 0; i < Math.min(nums.length, k); i++)
            add(nums[i]);
    }

    void add(int value) {
        if (size == arr.length)
            return;

        switch (size) {
            case 0:
                arr[0] = value;
                break;
            case 1:
                if (arr[0] > value) {
                    arr[1] = arr[0];
                    arr[0] = value;
                } else {
                    arr[1] = value;
                }
                break;
            default:
                int pos = Arrays.binarySearch(arr, 0, size, value);
                if (pos < 0)
                    pos = -pos - 1;

                System.arraycopy(arr, pos, arr, pos + 1, size - pos);
                arr[pos] = value;
        }
        size++;
    }

    public void replace(int prev, int next) {
        int pos = Arrays.binarySearch(arr, 0, size, prev);
        if (pos < 0)
            throw new IllegalStateException();

        size--;
        System.arraycopy(arr, pos + 1, arr, pos, size - pos);

        add(next);
    }

    public double median() {
        final int midIndex = arr.length >> 1;
        if (arr.length % 2 != 0)
            return arr[midIndex];
        return (arr[midIndex] + arr[midIndex - 1]) * 0.5;
    }

    @Override
    public String toString() {
        if (size == 0)
            return "[]";

        StringBuilder sb = new StringBuilder().append('[').append(arr[0]);
        for (int i = 1; i < size; i++)
            sb.append(',').append(' ').append(arr[i]);

        return sb.append(']').toString();
    }
}
