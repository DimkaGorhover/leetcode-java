package org.gd.leetcode.p0480;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-22
 */
class Result {

    private final double[] arr;
    private int index;

    Result(int capacity) {
        arr = new double[capacity];
        index = 0;
    }

    void add(double value) {
        if (index == arr.length)
            throw new ArrayIndexOutOfBoundsException();
        arr[index++] = value;
    }

    double[] array() { return arr; }
}
